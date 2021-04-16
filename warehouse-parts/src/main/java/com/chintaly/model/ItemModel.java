package com.chintaly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * This Class is responsible for provide access to data(Data Access Object).
 * 
 * @author Ricardo Quadros.
 * @version 1.0
 * @since 09/01/2018
 */
//TODO: include Inventory, Image, Part

@Entity
@Table(name = "Item")
public class ItemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_item",nullable=false)
	protected Integer idItem; // int(11)

	@Column(name = "bar_code", nullable = false)
	protected String barCode; // varchar(15) NOT NULL,

	@Column(name = "item_name", nullable = false)
	protected String itemName; // varchar(40) NOT NULL,

	@Column(name = "description", nullable = false)
	protected String description; // varchar(70) NOT NULL,

	@Column(name = "color", nullable = false)
	protected String color; // varchar(2) NOT NULL,

	@Column(name = "per_box", nullable = false)
	protected long perBox; // int(5) NOT NULL DEFAULT 1,

	@Column(name = "date_register", nullable = false)
	protected Date dateRegister; // int(5) NOT NULL DEFAULT 1,

	@Column(name = "record_flag", nullable = false)
	protected String recordFlag; // varchar(1) NOT NULL DEFAULT '1'

	public ItemModel() {
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		if(barCode.length() > 14) {
			this.barCode = barCode.substring(0, 14);
		} else {
			this.barCode = barCode;
		}
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		if(itemName.length() > 39) {
			this.itemName = itemName.substring(0, 39).toUpperCase();
		} else {
			this.itemName = itemName.toUpperCase();
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(description.length() > 69) {
		this.description = description.substring(0, 69).toUpperCase();
		} else {
			this.description = description.toUpperCase();
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color.length() > 29) {
		this.color = color.substring(0, 29).toUpperCase();
		} else {
			this.color = color.toUpperCase();
		}
	}

	public long getPerBox() {
		return perBox;
	}

	public void setPerBox(long perBox) {
		this.perBox = perBox;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getRecordFlag() {
		return recordFlag;
	}

	public void setRecordFlag(String recordFlag) {
		this.recordFlag = recordFlag;
	}

}
