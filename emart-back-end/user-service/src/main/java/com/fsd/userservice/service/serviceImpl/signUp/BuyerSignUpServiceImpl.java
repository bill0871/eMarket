package com.fsd.userservice.service.serviceImpl.signUp;

import com.fsd.userservice.dao.BuyerSignUpDao;
import com.fsd.userservice.entity.Buyer;
import com.fsd.userservice.service.SignUpService;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BuyerSignUpServiceImpl implements SignUpService<Buyer> {

    private final BuyerSignUpDao buyerSignUpDao;

    public BuyerSignUpServiceImpl(BuyerSignUpDao buyerSignUpDao) {
        this.buyerSignUpDao = buyerSignUpDao;
    }

    @Override
    public Buyer signUp(Buyer user) {
        user.setCreateTime(new Date());
        return buyerSignUpDao.save(user);
    }
}
