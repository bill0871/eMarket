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
        Item item1 = new Item();
        item1.setName("Mi 10 Pro");
        item1.setPrice(BigDecimal.valueOf(299.99));
        item1.setCategoryId(1);
        item1.setSubcategoryId(1);
        item1.setStockNumber(1888);

        Item item2 = new Item();
        item2.setName("Mi 10 Pro");
        item2.setPrice(BigDecimal.valueOf(299.99));
        item2.setCategoryId(1);
        item2.setSubcategoryId(1);
        item2.setStockNumber(1888);

        Item result1 = itemService.save(item1);
        Item result2 = itemService.save(item2);

        assertEquals(item1, result1);
        assertEquals(item2, result2);

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
        assertEquals(2, items.size());
    }


    @Test
    @Order(4)
    void findByName() {
        List<Item> items = itemService.findByName("Mi 10");
        assertEquals(2, items.size());
    }
}