package com.fsd.itemservice.controller;

import com.fsd.itemservice.entity.Item;
import com.fsd.itemservice.service.ItemService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public List<Item> getAllItems() {
        log.debug("...getAllItems...");
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Integer id) {
        Optional<Item> optionalItem = itemService.findById(id);
        return optionalItem.orElse(null);
    }

    @PostMapping("/")
    public Item newItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @GetMapping("/search/{name}")
    public List<Item> searchItemsByName(@PathVariable String name) {
        return itemService.findByName(name);
    }
}
