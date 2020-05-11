package com.fsd.userservice.dao;

import com.fsd.userservice.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerDao extends JpaRepository<Buyer, Long> {

}