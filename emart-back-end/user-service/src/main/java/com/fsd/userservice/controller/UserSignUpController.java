package com.fsd.userservice.controller;

import com.fsd.userservice.entity.Buyer;
import com.fsd.userservice.entity.Seller;
import com.fsd.userservice.service.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/signup")
public class UserSignUpController {

    private final SignUpService<Buyer> buyerSignUpService;

    private final SignUpService<Seller> sellerSignUpService;

    @Autowired
    public UserSignUpController(SignUpService<Buyer> buyerSignUpService,
            SignUpService<Seller> sellerSignUpService) {

        this.buyerSignUpService = buyerSignUpService;
        this.sellerSignUpService = sellerSignUpService;
    }

    @PostMapping("/buyer")
    public Buyer registerBuyer(@RequestBody Buyer buyer) {
        return buyerSignUpService.signUp(buyer);
    }

    @PostMapping("/seller")
    public Seller registerSeller(@RequestBody Seller seller) {
        return sellerSignUpService.signUp(seller);
    }
}
