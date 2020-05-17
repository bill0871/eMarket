package com.fsd.itemservice.controller;

import com.fsd.itemservice.entity.Item;
import com.fsd.itemservice.service.ItemService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public List<Item> getAllItems() {
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
    public List<Item> searchItems(@PathVariable String name) {
        return itemService.findByName(name);
    }
}
