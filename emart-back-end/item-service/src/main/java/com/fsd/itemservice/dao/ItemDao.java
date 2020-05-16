package com.fsd.itemservice.dao;

import com.fsd.itemservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Integer> {

}
