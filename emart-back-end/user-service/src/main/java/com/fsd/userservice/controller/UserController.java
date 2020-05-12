package com.fsd.userservice.controller;

import com.fsd.userservice.entity.Buyer;
import com.fsd.userservice.entity.Seller;
import com.fsd.userservice.service.SignInService;
import com.fsd.userservice.service.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    private final SignInService<Buyer> buyerSignInService;

    private final SignInService<Seller> sellerSignInService;

    private final SignUpService<Buyer> buyerSignUpService;

    private final SignUpService<Seller> sellerSignUpService;

    public UserController(SignInService<Buyer> buyerSignInService,
            SignInService<Seller> sellerSignInService,
            SignUpService<Buyer> buyerSignUpService,
            SignUpService<Seller> sellerSignUpService) {

        this.buyerSignInService = buyerSignInService;
        this.sellerSignInService = sellerSignInService;
        this.buyerSignUpService = buyerSignUpService;
        this.sellerSignUpService = sellerSignUpService;
    }

    @PostMapping("/registerBuyer")
    public Buyer registerBuyer(@RequestBody Buyer buyer) {
        return buyerSignUpService.signUp(buyer);
    }

    @PostMapping("/registerSeller")
    public Seller registerSeller(@RequestBody Seller seller) {
        log.info(seller.toString());
        return sellerSignUpService.signUp(seller);
    }

    @PostMapping("/signInBuyer")
    public Buyer signInBuyer(@RequestBody Buyer buyer) {
        return buyerSignInService.signIn(buyer);
    }

    @PostMapping("/signInSeller")
    public Seller signInSeller(@RequestBody Seller seller) {
        log.info(seller.toString());
        return sellerSignInService.signIn(seller);
    }

}
