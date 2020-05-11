package com.fsd.userservice.controller;

import com.fsd.userservice.entity.Buyer;
import com.fsd.userservice.service.BuyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BuyerController {

    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping("/registerBuyer")
    public void registerBuyer(@RequestBody Buyer buyer) {
        Buyer buyer1 = buyerService.registerBuyer(buyer);
        log.info(String.valueOf(buyer1.toString()));
    }
}
