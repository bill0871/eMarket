package com.fsd.buyerservice.service.impl;

import com.fsd.buyerservice.client.ItemClient;
import com.fsd.buyerservice.dao.CartDao;
import com.fsd.buyerservice.dao.PurchaseHistoryDao;
import com.fsd.buyerservice.entity.CartItem;
import com.fsd.buyerservice.entity.Item;
import com.fsd.buyerservice.entity.PurchaseHistory;
import com.fsd.buyerservice.service.BuyerService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Flux;

@Service
public class BuyerServiceImpl implements BuyerService {

    public static final String ITEM_SERVICE_HOST = "http://localhost:8903";
    private final WebClient webClient;
    private final ItemClient itemClient;
    private final CartDao cartDao;
    private final PurchaseHistoryDao purchaseHistoryDao;

    @Autowired
    public BuyerServiceImpl(Builder builder, ItemClient itemClient,
        CartDao cartDao,
        PurchaseHistoryDao purchaseHistoryDao) {

        this.webClient = builder.baseUrl(ITEM_SERVICE_HOST).build();
        this.itemClient = itemClient;
        this.cartDao = cartDao;
        this.purchaseHistoryDao = purchaseHistoryDao;
    }

    @Override
    public List<Item> searchItems(String name) {
        return itemClient.searchItems(name);
    }

    @Override
    public CartItem addToCart(Item item, Integer userId) {

        // 1. check whether the record of specific item associate with specific user exist in cart
        Optional<CartItem> optionalCartItem =
            cartDao.findCartItemByItemIdAndUserId(item.getId(), userId);
        CartItem cartItem;

        if (optionalCartItem.isPresent()) {
            // if exist, select that one, qty + 1
            cartItem = optionalCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            // if not exist, add one record in cart, set qty = 1
            cartItem = new CartItem();
            cartItem.setItemId(item.getId());
            cartItem.setUserId(userId);
            cartItem.setQuantity(1);
        }
        return cartDao.save(cartItem);
    }

    @Override
    public void deleteFromCart(CartItem cartItem) {
        cartDao.delete(cartItem);
    }

    @Override
    public List<PurchaseHistory> checkout(List<CartItem> cartItems) {
        Flux<Item> itemFlux = webClient.get()
            .uri("/item/")
            .retrieve()
            .bodyToFlux(Item.class);
        List<Item> items = itemFlux.collectList().block();
        ArrayList<PurchaseHistory> list = new ArrayList<>();
        if (items != null) {
            Map<Integer, Integer> itemSellerIdMap = items.stream()
                .collect(Collectors.toMap(Item::getId, Item::getSellerId));
            cartItems.forEach(cartItem -> {
                PurchaseHistory purchaseHistory = new PurchaseHistory();
                purchaseHistory.setBuyerId(cartItem.getUserId());
                purchaseHistory.setSellerId(itemSellerIdMap.get(cartItem.getItemId()));
                purchaseHistory.setItemId(cartItem.getItemId());
                purchaseHistory.setNumberOfItems(cartItem.getQuantity());
                purchaseHistory.setCreateDate(new Date());

                list.add(purchaseHistory);
            });
        }

        return purchaseHistoryDao.saveAll(list);
    }
}
