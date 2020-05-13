package com.fsd.userservice.service.serviceImpl.signUp;

import com.fsd.userservice.entity.Buyer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BuyerSignUpServiceImplTest {

    @Autowired
    private BuyerSignUpServiceImpl buyerSignUpService;

    @Test
    void signUp() {
        Buyer buyer = new Buyer();
        buyer.setUsername("Bob");
        buyer.setPassword("aaa");
        buyer.setEmail("ccc@bcd.com");
        Buyer buyer1 = buyerSignUpService.signUp(buyer);

        Assertions.assertEquals(buyer, buyer1);
    }
}