package com.fsd.userservice.controller;

import com.fsd.commonmodel.model.ServerResponse;
import com.fsd.userservice.entity.Buyer;
import com.fsd.userservice.entity.Seller;
import com.fsd.userservice.service.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ServerResponse<Buyer> registerBuyer(@RequestBody Buyer buyer) {
        Buyer result = buyerSignUpService.find(buyer);
        if (result == null) {
            Buyer signUpBuyer = buyerSignUpService.signUp(buyer);
            return ServerResponse.successWithDefaultCode(signUpBuyer);
        }
        result.setPassword(null);
        result.setMobile(null);
        result.setEmail(null);
        result.setCreateTime(null);
        return ServerResponse.errorWithMsg(500005, "The user has already exist!", result);
    }

    @PostMapping("/seller")
    public Seller registerSeller(@RequestBody Seller seller) {
        return sellerSignUpService.signUp(seller);
    }

    @GetMapping("/buyer")
    public String hello() {
        return "hello";
    }


}
