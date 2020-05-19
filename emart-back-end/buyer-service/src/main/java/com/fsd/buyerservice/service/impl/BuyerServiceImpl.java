package com.fsd.buyerservice.service.impl;

import com.fsd.buyerservice.dao.CartDao;
import com.fsd.buyerservice.entity.CartItem;
import com.fsd.buyerservice.entity.Item;
import com.fsd.buyerservice.service.BuyerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class BuyerServiceImpl implements BuyerService {

    public static final String ITEM_SERVICE_HOST = "http://localhost:8903";
    private final WebClient webClient;
    private final CartDao cartDao;

    @Autowired
    public BuyerServiceImpl(WebClient.Builder builder, CartDao cartDao) {
        this.webClient = builder.baseUrl(ITEM_SERVICE_HOST).build();
        this.cartDao = cartDao;
    }

    @Override
    public List<Item> searchItems(String name) {
        Flux<Item> itemFlux = webClient.get()
                .uri("/item/search/{name}", name)
                .retrieve()
                .bodyToFlux(Item.class);

        return itemFlux.collectList().block();
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
}
