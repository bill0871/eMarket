package com.fsd.buyerservice.dao;

import com.fsd.buyerservice.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseHistoryDao extends JpaRepository<PurchaseHistory, Integer> {

}
