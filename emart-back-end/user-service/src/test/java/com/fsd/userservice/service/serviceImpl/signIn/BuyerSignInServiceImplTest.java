package com.fsd.userservice.service.serviceImpl.signIn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fsd.userservice.entity.Buyer;
import com.fsd.userservice.service.serviceImpl.signUp.BuyerSignUpServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BuyerSignInServiceImplTest {

    @Autowired
    private BuyerSignInServiceImpl buyerSignInService;
    @Autowired
    private BuyerSignUpServiceImpl buyerSignUpService;

    private Buyer buyer;


    @BeforeEach
    void setUp() {
        Buyer buyer = new Buyer();
        buyer.setUsername("bill");
        buyer.setPassword("aaabbccc");
        buyer.setMobile("18293029182");
        this.buyer = buyerSignUpService.signUp(buyer);
    }

    @Test
    void signIn() {
        Buyer buyer = new Buyer();
        buyer.setUsername("bill");
        buyer.setPassword("aaabbccc");
        buyer.setMobile("18293029182");

        Buyer buyer1 = buyerSignInService.signIn(buyer);

        assertEquals(this.buyer, buyer1);
    }
}