package com.fsd.itemservice.dao;

import com.fsd.itemservice.entity.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Integer> {

    List<Item> findItemsByNameContaining(String name);
}
