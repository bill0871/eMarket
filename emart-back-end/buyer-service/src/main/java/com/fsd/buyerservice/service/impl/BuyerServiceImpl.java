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
    public CartItem addToCart(Item item) {

        // 1. check whether the specific item exist in cart
        // 2. if exist
        //      select that one, qty + 1
        //    if not exist
        //      add one in cart set qty = 1

        // TODO Exception:save the transient instance before flushing!!!
        Optional<CartItem> optionalCartItem = cartDao.findByItem(item);
        CartItem cartItem;
        if (optionalCartItem.isPresent()) {
            cartItem = optionalCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            cartItem = new CartItem();
            cartItem.setItem(item);
            cartItem.setQuantity(1);
        }
        cartDao.save(cartItem);

        return null;
    }
}
