package com.fsd.userservice.service.serviceImpl.signIn;

import com.fsd.userservice.dao.SellerSignInDao;
import com.fsd.userservice.entity.Seller;
import com.fsd.userservice.service.SignInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SellerSignInServiceImpl implements SignInService<Seller> {

    private final SellerSignInDao sellerSignInDao;

    public SellerSignInServiceImpl(SellerSignInDao sellerSignInDao) {
        this.sellerSignInDao = sellerSignInDao;
    }

    @Override
    public Seller signIn(Seller user) {
        return sellerSignInDao.save(user);
    }
}
