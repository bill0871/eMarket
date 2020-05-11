package com.fsd.userservice.service.serviceImpl.signIn;

import com.fsd.userservice.dao.BuyerSignInDao;
import com.fsd.userservice.entity.Buyer;
import com.fsd.userservice.service.SignInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BuyerSignInServiceImpl implements SignInService<Buyer> {

    private final BuyerSignInDao buyerSignInDao;

    public BuyerSignInServiceImpl(BuyerSignInDao buyerSignInDao) {
        this.buyerSignInDao = buyerSignInDao;
    }

    @Override
    public Buyer signIn(Buyer user) {
        return buyerSignInDao.save(user);
    }
}
