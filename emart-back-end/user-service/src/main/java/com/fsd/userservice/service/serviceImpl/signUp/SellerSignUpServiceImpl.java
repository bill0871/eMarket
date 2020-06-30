package com.fsd.userservice.service.serviceImpl.signUp;

import com.fsd.userservice.dao.SellerSignUpDao;
import com.fsd.userservice.entity.Seller;
import com.fsd.userservice.service.SignUpService;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SellerSignUpServiceImpl implements SignUpService<Seller> {


    private final SellerSignUpDao sellerSignUpDao;

    @Autowired
    public SellerSignUpServiceImpl(SellerSignUpDao sellerSignUpDao) {
        this.sellerSignUpDao = sellerSignUpDao;
    }


    @Override
    public Seller signUp(Seller user) {
        user.setCreateTime(new Date());
        return sellerSignUpDao.save(user);
    }

    @Override
    public Seller find(Seller user) {
        return null;
    }
}
