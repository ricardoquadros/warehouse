package com.qsys.item.controller;

import com.qsys.item.entity.Item;
import com.qsys.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> itemList = itemService.getAllItems();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/getItemById/{id}")
    public Item getItemById(@PathVariable Integer id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/findItemByItemName/{itemName}")
    public Item getItemByItemName(@PathVariable String itemName) {
        return itemService.getItemByItemName(itemName);
    }

    @PostMapping("/saveItem")
    public Item saveUser(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @PutMapping("/updateItem")
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @DeleteMapping("/deleteItemById/{id}")
    public void deleteItemById(@PathVariable Integer id) {
        itemService.deleteItemById(id);
    }

}
