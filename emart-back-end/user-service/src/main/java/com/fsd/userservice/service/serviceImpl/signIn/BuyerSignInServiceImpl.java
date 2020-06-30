package com.fsd.userservice.service.serviceImpl.signIn;

import com.fsd.userservice.dao.BuyerSignInDao;
import com.fsd.userservice.entity.Buyer;
import com.fsd.userservice.service.SignInService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BuyerSignInServiceImpl implements SignInService<Buyer> {

    private final BuyerSignInDao buyerSignInDao;

    @Autowired
    public BuyerSignInServiceImpl(BuyerSignInDao buyerSignInDao) {
        this.buyerSignInDao = buyerSignInDao;
    }

    @Override
    public Buyer signIn(Buyer user) {
        Optional<Buyer> targetUser = buyerSignInDao.findByUsername(user.getUsername());
        return targetUser.filter(t -> user.getPassword().equals(t.getPassword())).orElse(null);
    }
}
