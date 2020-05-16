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
        String username = user.getUsername();
        Optional<Buyer> buyer = buyerSignInDao.findByUsername(username);

        return buyer.map(b -> {
            String password = b.getPassword();
            String password1 = user.getPassword();
            return password.equals(password1) ? b : null;
        }).orElse(null);

    }
}
