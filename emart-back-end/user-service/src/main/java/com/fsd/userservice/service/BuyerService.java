package com.fsd.userservice.service;

import com.fsd.userservice.dao.BuyerDao;
import com.fsd.userservice.entity.Buyer;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    private final BuyerDao buyerDao;

    public BuyerService(BuyerDao buyerDao) {
        this.buyerDao = buyerDao;
    }

    public Buyer registerBuyer(Buyer buyer) {

        buyer.setCreateTime(new Date());
        return buyerDao.save(buyer);
    }
}