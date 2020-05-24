package com.fsd.sellerservice.controller;

import com.fsd.sellerservice.entity.Item;
import com.fsd.sellerservice.service.impl.SellerServiceImpl;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private final SellerServiceImpl sellerServiceImpl;

    @Autowired
    public SellerController(SellerServiceImpl sellerServiceImpl) {
        this.sellerServiceImpl = sellerServiceImpl;
    }

    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item) {
        return sellerServiceImpl.addItem(item);
    }

    @GetMapping("/viewStock/{name}")
    public Map<String, Integer> viewStock(@PathVariable String name) {
        return sellerServiceImpl.viewStock(name);
    }
}
