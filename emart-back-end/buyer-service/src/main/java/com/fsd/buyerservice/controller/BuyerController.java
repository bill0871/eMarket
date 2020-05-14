package com.fsd.buyerservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {

    @RequestMapping("/hello")
    public String registerBuyer() {
        return "hello world";
    }
}
