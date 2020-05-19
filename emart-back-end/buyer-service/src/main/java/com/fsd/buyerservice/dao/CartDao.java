package com.fsd.buyerservice.dao;

import com.fsd.buyerservice.entity.CartItem;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<CartItem, Integer> {

    Optional<CartItem> findCartItemByItemIdAndUserId(Integer itemId, Integer userId);
}
