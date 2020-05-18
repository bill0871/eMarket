package com.fsd.buyerservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.fsd.buyerservice.entity.Item;
import com.fsd.buyerservice.service.BuyerService;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@Slf4j
class BuyerServiceImplTest {

    @Mock
    private BuyerService buyerService;

    @Test
    void searchItems() {
        String mi = "Mi 10";
        when(buyerService.searchItems(mi)).thenReturn(GetSearchedItems());
        assertEquals(buyerService.searchItems(mi).size(), GetSearchedItems().size());
        log.info("{}:{}", buyerService.searchItems(mi).size(), GetSearchedItems().size());
    }

    @Test
    void addToCart() {
    }

    private List<Item> GetSearchedItems() {
        Item item1 = new Item();
        item1.setCategoryId(1);
        item1.setSubcategoryId(2);
        item1.setPrice(new BigDecimal("199"));
        item1.setName("Mi 10");
        item1.setStockNumber(1234);

        Item item2 = new Item();
        item2.setCategoryId(1);
        item2.setSubcategoryId(2);
        item2.setPrice(new BigDecimal("149"));
        item2.setName("Mi 10 Lite");
        item2.setStockNumber(2291);

        return Arrays.asList(item1, item2);
    }
}