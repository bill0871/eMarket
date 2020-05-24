package com.fsd.buyerservice.service;

import com.fsd.buyerservice.entity.CartItem;
import com.fsd.buyerservice.entity.Item;
import com.fsd.buyerservice.entity.PurchaseHistory;
import java.util.List;

public interface BuyerService {

    List<Item> searchItems(String name);

    CartItem addToCart(Item item, Integer userId);

    void deleteFromCart(CartItem cartItem);

    List<PurchaseHistory> checkout(List<CartItem> cartItems);
}
