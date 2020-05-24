package com.fsd.sellerservice.service.impl;

import com.fsd.sellerservice.entity.Item;
import com.fsd.sellerservice.service.SellerService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;

@Service
public class SellerServiceImpl implements SellerService {

    public static final String ITEM_SERVICE_HOST = "http://localhost:8903";
    private final WebClient webClient;

    @Autowired
    public SellerServiceImpl(Builder builder) {
        this.webClient = builder.baseUrl(ITEM_SERVICE_HOST).build();
    }

    @Override
    public Item addItem(Item item) {

        Mono<Item> itemMono = webClient.post()
                .uri("/item/")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(item)
                .retrieve()
                .bodyToMono(Item.class);

        return itemMono.block();
    }

    public Map<String, Integer> viewStock(String name) {
        Mono<Item> itemMono = webClient.get()
                .uri("/item/search/{name}", name)
                .retrieve()
                .bodyToMono(Item.class);

        Item item = itemMono.block();
        Integer stockNumber = item.getStockNumber();




        return null;
    }
}
