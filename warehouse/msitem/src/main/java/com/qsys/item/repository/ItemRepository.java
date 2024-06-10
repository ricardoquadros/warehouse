package com.qsys.item.repository;

import com.qsys.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Integer> {


    @Query("SELECT u FROM Item u WHERE u.itemName = ?1")
    Item getItemByItemName(String itemName);
}
