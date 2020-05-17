package com.fsd.buyerservice.controller;

import com.fsd.buyerservice.entity.Item;
import com.fsd.buyerservice.service.BuyerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {

    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @RequestMapping("/hello")
    public String registerBuyer() {
        return "hello world";
    }

    @GetMapping("/search/{name}")
    public List<Item> searchItems(@PathVariable String name) {
        return buyerService.searchItems(name);
    }

}
