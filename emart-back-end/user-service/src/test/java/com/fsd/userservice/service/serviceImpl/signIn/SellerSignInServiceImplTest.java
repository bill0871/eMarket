package com.fsd.userservice.service.serviceImpl.signIn;

import static org.junit.jupiter.api.Assertions.*;

import com.fsd.userservice.entity.Seller;
import com.fsd.userservice.service.serviceImpl.signUp.SellerSignUpServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SellerSignInServiceImplTest {

    @Autowired
    private SellerSignInServiceImpl sellerSignInService;

    @Autowired
    private SellerSignUpServiceImpl sellerSignUpService;

    private Seller seller;

    @BeforeEach
    void setUp() {
        Seller seller = new Seller();
        seller.setUsername("cron");
        seller.setPassword("aaa");
        seller.setEmail("ccc@bcd.com");
        this.seller = sellerSignUpService.signUp(seller);
    }

    @Test
    void signIn() {
        Seller seller = new Seller();
        seller.setUsername("cron");
        seller.setPassword("aaa");
        seller.setEmail("ccc@bcd.com");

        Seller seller1 = sellerSignInService.signIn(seller);

        assertEquals(this.seller, seller1);
    }
}