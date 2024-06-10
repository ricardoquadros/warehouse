package com.qsys.item.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Item {

    protected Integer idItem; // int(11)
    protected String barCode; // varchar(15) NOT NULL,
    protected String itemName; // varchar(40) NOT NULL,
    protected String description; // varchar(70) NOT NULL,
    protected String color; // varchar(2) NOT NULL,
    protected long perBox; // int(5) NOT NULL DEFAULT 1,
    protected Date dateRegister; // int(5) NOT NULL DEFAULT 1,
    protected String recordFlag; // varchar(1) NOT NULL DEFAULT '1'


    public Item() {
    }

    public Item(Integer idItem, String itemName, String description) {
        this.idItem = idItem;
        this.itemName = itemName;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdItem() {
        return this.idItem;
    }

}
