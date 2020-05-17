package com.fsd.buyerservice.service;

import com.fsd.buyerservice.entity.Item;
import java.util.List;

public interface BuyerService {

    List<Item> searchItems(String name);

    Item addToCart(Item item);
}
