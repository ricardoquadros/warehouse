package com.chintaly.view;

import java.math.BigDecimal;
import java.util.Date;

public class ItemInventoryView {

	//Item
	private long idItem;
	private long perBox;
	private String barCode;
	private String itemName;
	private String description;
	private String color;
	private Date dateRegister;

	//Item_Inventory
	private long idItemInventory;
	private long idWarehouse;
	private long idWarehouseLocation;
	private BigDecimal qty;
	private Date dateLastIn;
	private Date dateLastOut;
	private String notes;

	//Item_Part
	private long idItemPart;
	private String itemPartName;

	public ItemInventoryView() {
	}

	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public long getPerBox() {
		return perBox;
	}

	public void setPerBox(long perBox) {
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

	public long getIdItemInventory() {
		return idItemInventory;
	}

	public void setIdItemInventory(long idItemInventory) {
		this.idItemInventory = idItemInventory;
	}

	public long getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(long idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public long getIdWarehouseLocation() {
		return idWarehouseLocation;
	}

	public void setIdWarehouseLocation(long idWarehouseLocation) {
		this.idWarehouseLocation = idWarehouseLocation;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
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

	public long getIdItemPart() {
		return idItemPart;
	}

	public void setIdItemPart(long idItemPart) {
		this.idItemPart = idItemPart;
	}

	public String getItemPartName() {
		return itemPartName;
	}

	public void setItemPartName(String itemPartName) {
		this.itemPartName = itemPartName;
	}
	
}
