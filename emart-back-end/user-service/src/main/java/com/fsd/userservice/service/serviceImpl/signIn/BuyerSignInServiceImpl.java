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
        String username = user.getUsername();
        Buyer buyer = buyerSignInDao.findByUsername(username);
        if (buyer != null) {
            String password = buyer.getPassword();
            String inputPassword = user.getPassword();
            if (password.equals(inputPassword)) {
                return buyer;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
