package com.fsd.buyerservice.dao;

import com.fsd.buyerservice.entity.CartItem;
import com.fsd.buyerservice.entity.Item;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<CartItem, Integer> {

    Optional<CartItem> findByItem(Item item);
}
