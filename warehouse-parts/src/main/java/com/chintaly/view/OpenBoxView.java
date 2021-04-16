package com.chintaly.view;

import java.math.BigDecimal;
import java.util.Date;

public class OpenBoxView {

	//Item
	private Integer idItem;
	private Integer perBox;
	private String barCode;
	private String itemName;
	private String description;
	private String color;
	private Date dateRegister;

	//Open_Box_Inventory
	private Integer idOpenBoxInventory;
	private Integer idWarehouse;
	private Integer idWarehouseLocation;
	private BigDecimal qty;
	private Date dateCheckIn;
	private Date dateCheckOut;
	private String notes;
	private String partTaken;
	private String packingSlip;
	private String approvedBy;
	private String poNumber;
	private String sequentialNumber;
	private String descStatus;
	
	//Item_Part
	private Integer idItemPart;
	private String itemPartName;

	public OpenBoxView() {}

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

	public Integer getIdOpenBoxInventory() {
		return idOpenBoxInventory;
	}

	public void setIdOpenBoxInventory(Integer idOpenBoxInventory) {
		this.idOpenBoxInventory = idOpenBoxInventory;
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

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public Date getDateCheckIn() {
		return dateCheckIn;
	}

	public void setDateCheckIn(Date dateCheckIn) {
		this.dateCheckIn = dateCheckIn;
	}

	public Date getDateCheckOut() {
		return dateCheckOut;
	}

	public void setDateCheckOut(Date dateCheckOut) {
		this.dateCheckOut = dateCheckOut;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPartTaken() {
		return partTaken;
	}

	public void setPartTaken(String partTaken) {
		this.partTaken = partTaken;
	}

	public String getPackingSlip() {
		return packingSlip;
	}

	public void setPackingSlip(String packingSlip) {
		this.packingSlip = packingSlip;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
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

	public String getDescStatus() {
		return descStatus;
	}

	public void setDescStatus(String descStatus) {
		this.descStatus = descStatus;
	}

}
