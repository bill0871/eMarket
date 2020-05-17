package com.fsd.buyerservice.service.impl;

import com.fsd.buyerservice.entity.Item;
import com.fsd.buyerservice.service.BuyerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class BuyerServiceImpl implements BuyerService {

    private final WebClient webClient;

    @Autowired
    public BuyerServiceImpl(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8903").build();
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
    public Item addToCart(Item item) {
        return null;
    }
}
