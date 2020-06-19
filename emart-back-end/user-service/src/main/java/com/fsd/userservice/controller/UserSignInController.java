package com.fsd.userservice.controller;

import com.fsd.userservice.entity.Buyer;
import com.fsd.userservice.entity.Seller;
import com.fsd.userservice.service.SignInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/login")
public class UserSignInController {

    private final SignInService<Buyer> buyerSignInService;

    private final SignInService<Seller> sellerSignInService;

    @Autowired
    public UserSignInController(SignInService<Buyer> buyerSignInService,
            SignInService<Seller> sellerSignInService) {

        this.buyerSignInService = buyerSignInService;
        this.sellerSignInService = sellerSignInService;
    }

    @PostMapping("/buyer")
    public Buyer signInBuyer(@RequestBody Buyer buyer) {
        Buyer user = buyerSignInService.signIn(buyer);
        return user;
    }

    @PostMapping("/seller")
    public Seller signInSeller(@RequestBody Seller seller) {
        return sellerSignInService.signIn(seller);
    }

}
