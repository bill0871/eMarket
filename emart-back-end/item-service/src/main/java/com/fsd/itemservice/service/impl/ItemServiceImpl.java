package com.fsd.itemservice.service.impl;

import com.fsd.itemservice.dao.ItemDao;
import com.fsd.itemservice.entity.Item;
import com.fsd.itemservice.service.ItemService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemDao itemDao;

    @Autowired
    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public Item save(Item item) {
        return itemDao.save(item);
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return itemDao.findById(id);
    }

    @Override
    public List<Item> findAll() {
        return itemDao.findAll();
    }

    @Override
    public List<Item> findByName(String name) {
        return itemDao.findItemsByNameContaining(name);
    }
}
