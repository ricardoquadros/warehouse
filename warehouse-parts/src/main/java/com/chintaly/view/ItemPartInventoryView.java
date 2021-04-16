package com.chintaly.view;

import java.math.BigDecimal;
import java.util.Date;

public class ItemPartInventoryView {

	//Item
	private Integer idItem;
	private Integer perBox;
	private String barCode;
	private String itemName;
	private String description;
	private String color;
	private Date dateRegister;

	//Item Part Inventory
	private Integer idItemPartInventory;
	private Integer idWarehouse;
	private Integer idWarehouseLocation;
	private BigDecimal qty;
	private Date dateLastIn;
	private Date dateLastOut;
	private String notes;
	private String sequentialNumber;

	//Item_Part
	private Integer idItemPart;
	private String itemPartName;

	public ItemPartInventoryView() {
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getPerBox() {
		return perBox;
	}

	public void setPerBox(Integer perBox) {
		this.perBox = perBox;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public Integer getIdItemPartInventory() {
		return idItemPartInventory;
	}

	public void setIdItemPartInventory(Integer idItemPartInventory) {
		this.idItemPartInventory = idItemPartInventory;
	}

	public Integer getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(Integer idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public Integer getIdWarehouseLocation() {
		return idWarehouseLocation;
	}

	public void setIdWarehouseLocation(Integer idWarehouseLocation) {
		this.idWarehouseLocation = idWarehouseLocation;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty2) {
		this.qty = qty2;
	}

	public Date getDateLastIn() {
		return dateLastIn;
	}

	public void setDateLastIn(Date dateLastIn) {
		this.dateLastIn = dateLastIn;
	}

	public Date getDateLastOut() {
		return dateLastOut;
	}

	public void setDateLastOut(Date dateLastOut) {
		this.dateLastOut = dateLastOut;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getIdItemPart() {
		return idItemPart;
	}

	public void setIdItemPart(Integer idItemPart) {
		this.idItemPart = idItemPart;
	}

	public String getItemPartName() {
		return itemPartName;
	}

	public void setItemPartName(String itemPartName) {
		this.itemPartName = itemPartName;
	}

	public String getSequentialNumber() {
		return sequentialNumber;
	}

	public void setSequentialNumber(String sequentialNumber) {
		this.sequentialNumber = sequentialNumber;
	}
	
}
