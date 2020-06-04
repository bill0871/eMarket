package com.fsd.buyerservice.client;

import com.fsd.buyerservice.entity.Item;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "item-service")
public interface ItemClient {

    @GetMapping("item/search/{itemName}")
    List<Item> searchItems(@PathVariable String itemName);
}
