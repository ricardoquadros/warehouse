package com.chintaly.view;

import java.math.BigDecimal;
import java.util.Date;

public class PackingSlipView {

	//part_history
	private Integer idPartHistory;
	private BigDecimal qtyStock;
	private BigDecimal qty;
	private Date date;
	private Date dateCheckIN;
	private Date dateCheckOUT;
	private String partTaken;
	private String packingSlip;
	private String approvedBy;
	private String billShip;
	private String poNumber;
	private String poNumberInvoice;
	private String sequentialNumber;
	private String recordFlag;
	
	//Item
	private Integer idItem;
	private Integer perBox;
	private String barCode;
	private String itemName;
	private String description;
	private String color;
	private Date dateRegister;
	
	//Item_Inventory
	private Integer idItemInventory;
	private Integer idWarehouse;
	private Integer idWarehouseLocation;
	private Integer qtyUnit;
	private Date dateLastIn;
	private Date dateLastOut;
	private String notes;

	//Item_Part
	private Integer idItemPart;
	private String itemPartName;
	
	//Image
	private Integer idImage;

	//status
	private Integer idStatus;
	private String status;
	
	private String userPackingSlip;
	private String dimension;
	private String weight;
	private String freight;
	private Integer emailSentCount;
	
	public PackingSlipView() {}
		
	public Integer getIdPartHistory() {
		return idPartHistory;
	}
	public void setIdPartHistory(Integer idPartHistory) {
		this.idPartHistory = idPartHistory;
	}
	public BigDecimal getQtyStock() {
		return qtyStock;
	}
	public void setQtyStock(BigDecimal qtyStock) {
		this.qtyStock = qtyStock;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDateCheckIN() {
		return dateCheckIN;
	}
	public void setDateCheckIN(Date dateCheckIN) {
		this.dateCheckIN = dateCheckIN;
	}
	public Date getDateCheckOUT() {
		return dateCheckOUT;
	}
	public void setDateCheckOUT(Date dateCheckOUT) {
		this.dateCheckOUT = dateCheckOUT;
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
	public String getBillShip() {
		return billShip;
	}
	public void setBillShip(String billShip) {
		this.billShip = billShip;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getPoNumberInvoice() {
		return poNumberInvoice;
	}
	public void setPoNumberInvoice(String poNumberInvoice) {
		this.poNumberInvoice = poNumberInvoice;
	}
	public String getSequentialNumber() {
		return sequentialNumber;
	}
	public void setSequentialNumber(String sequentialNumber) {
		this.sequentialNumber = sequentialNumber;
	}
	public String getRecordFlag() {
		return recordFlag;
	}
	public void setRecordFlag(String recordFlag) {
		this.recordFlag = recordFlag;
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
	public Integer getIdItemInventory() {
		return idItemInventory;
	}
	public void setIdItemInventory(Integer idItemInventory) {
		this.idItemInventory = idItemInventory;
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
	public Integer getQtyUnit() {
		return qtyUnit;
	}
	public void setQtyUnit(Integer qtyUnit) {
		this.qtyUnit = qtyUnit;
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
	public Integer getIdImage() {
		return idImage;
	}
	public void setIdImage(Integer idImage) {
		this.idImage = idImage;
	}
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserPackingSlip() {
		return userPackingSlip;
	}

	public void setUserPackingSlip(String userPackingSlip) {
		this.userPackingSlip = userPackingSlip;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public Integer getEmailSentCount() {
		return emailSentCount;
	}

	public void setEmailSentCount(Integer emailSentCount) {
		this.emailSentCount = emailSentCount;
	}
	
}
