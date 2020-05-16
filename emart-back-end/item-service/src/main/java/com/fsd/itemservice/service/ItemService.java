package com.fsd.itemservice.service;

import com.fsd.itemservice.entity.Item;
import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    Optional<Item> findById(Integer id);

    List<Item> findAll();

    List<Item> findByName(String name);
}
