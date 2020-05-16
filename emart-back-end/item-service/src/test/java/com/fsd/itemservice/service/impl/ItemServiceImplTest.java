package com.fsd.itemservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fsd.itemservice.entity.Item;
import com.fsd.itemservice.service.ItemService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
class ItemServiceImplTest {

    @Autowired
    private ItemService itemService;

    @Test
    @Order(1)
    void save() {
        Item item = new Item();
        item.setName("Mi 10 Pro");
        item.setPrice(BigDecimal.valueOf(299.99));
        item.setCategoryId(1);
        item.setSubcategoryId(1);
        item.setStockNumber(1888);

        Item result = itemService.save(item);

        assertEquals(item, result);

    }

    @Test
    @Order(2)
    void findById() {
        Optional<Item> itemOptional = itemService.findById(1);
        assertNotNull(itemOptional.orElse(null));
    }

    @Test
    @Order(3)
    void findAll() {
        List<Item> items = itemService.findAll();
        assertEquals(1, items.size());
    }
}