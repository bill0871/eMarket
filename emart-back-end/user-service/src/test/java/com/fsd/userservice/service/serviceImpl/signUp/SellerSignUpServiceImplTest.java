package com.fsd.userservice.service.serviceImpl.signUp;

import static org.junit.jupiter.api.Assertions.*;

import com.fsd.userservice.entity.Buyer;
import com.fsd.userservice.entity.Seller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SellerSignUpServiceImplTest {

    @Autowired
    private SellerSignUpServiceImpl sellerSignUpService;

    @Test
    void signUp() {
        Seller seller = new Seller();
        seller.setUsername("crazy");
        seller.setPassword("aaa");
        seller.setEmail("ccc@bcd.com");
        Seller seller1 = sellerSignUpService.signUp(seller);

        Assertions.assertEquals(seller, seller1);

    }
}