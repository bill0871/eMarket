package com.fsd.buyerservice.controller;

import com.fsd.buyerservice.entity.CartItem;
import com.fsd.buyerservice.entity.Item;
import com.fsd.buyerservice.entity.PurchaseHistory;
import com.fsd.buyerservice.service.BuyerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping("/search/{name}")
    public List<Item> searchItems(@PathVariable String name) {
        return buyerService.searchItems(name);
    }

    @PostMapping("/addToCart")
    public CartItem addToCart(@RequestBody Item item, Integer userId) {
        return buyerService.addToCart(item, userId);
    }

    @PostMapping("/deleteFromCart")
    public void deleteFromCart(@RequestBody CartItem cartItem) {
        buyerService.deleteFromCart(cartItem);
    }

    @PostMapping("/checkout")
    public List<PurchaseHistory> checkout(@RequestBody List<CartItem> cartItems) {
        return buyerService.checkout(cartItems);
    }

}
