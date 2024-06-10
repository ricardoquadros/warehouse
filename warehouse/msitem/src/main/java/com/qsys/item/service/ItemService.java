package com.qsys.item.service;

import com.qsys.item.entity.Item;
import com.qsys.item.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Integer id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(new Item());
    }

    public Item getItemByItemName(String itemName) {
        Optional<Item> item = Optional.ofNullable(itemRepository.getItemByItemName(itemName));
        return item.orElse(new Item());
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItemById(Integer id) {
        itemRepository.deleteById(id);
    }

}
