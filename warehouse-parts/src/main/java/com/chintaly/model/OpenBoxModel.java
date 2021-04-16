package com.chintaly.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Open_Box_Inventory")
public class OpenBoxModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id_open_box_inventory", nullable = false)
	protected Integer idOpenBoxInventory; // | int(11) unsigned

	@Column(name = "id_warehouse_location", nullable = false)
	protected Integer idWarehouseLocation; // | int(11)

	@Column(name = "id_warehouse", nullable = false)
	protected Integer idWarehouse; // | int(11)

	//@Column(name = "id_image", nullable = false)
	//protected Integer idImage; // | int(11)

	@Column(name = "id_item", nullable = false)
	protected Integer idItem; // | int(11)

	@Column(name = "id_item_part", nullable = false)
	protected Integer idItemPart; // | int(11)

	@Column(name = "id_item_inventory", nullable = false)
	protected Integer idItemInventory; // | int(11)

	@Column(name = "id_status", nullable = false)
	protected Integer idStatus; // | int(11)

	@Column(name = "qty", nullable = false)
	protected BigDecimal qty; // | int(11)

	@Column(name = "date_checkin", nullable = false)
	protected Date dateCheckIn; // | date

	@Column(name = "date_checkout", nullable = false)
	protected Date dateCheckOut; // | date

	//@Column(name = "part_taken", nullable = false)
	//protected String partTaken; // | varchar(250)

	@Column(name = "packingslip", nullable = false)
	protected String packingSlip; // | varchar(10)

	@Column(name = "approved_by", nullable = false)
	protected String approvedBy; // | varchar(20)

	@Column(name = "notes", nullable = false)
	protected String notes; // | varchar(250)

	@Column(name = "po_number", nullable = false)
	protected String poNumber; // | varchar(15)

	@Column(name = "sequential_number", nullable = false)
	protected String sequentialNumber; // | varchar(15)

	@Column(name = "record_flag", nullable = false)
	protected String recordFlag; // | varchar(1)

	public OpenBoxModel() {
	}

	public Integer getIdOpenBoxInventory() {
		return idOpenBoxInventory;
	}

	public void setIdOpenBoxInventory(Integer idOpenBoxInventory) {
		this.idOpenBoxInventory = idOpenBoxInventory;
	}

	public Integer getIdWarehouseLocation() {
		return idWarehouseLocation;
	}

	public void setIdWarehouseLocation(Integer idWarehouseLocation) {
		this.idWarehouseLocation = idWarehouseLocation;
	}

	public Integer getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(Integer idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

//	public Integer getIdImage() {
//		return idImage;
//	}
//
//	public void setIdImage(Integer idImage) {
//		this.idImage = idImage;
//	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getIdItemPart() {
		return idItemPart;
	}

	public void setIdItemPart(Integer idItemPart) {
		this.idItemPart = idItemPart;
	}

	public Integer getIdItemInventory() {
		return idItemInventory;
	}

	public void setIdItemInventory(Integer idItemInventory) {
		this.idItemInventory = idItemInventory;
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

//	public String getPartTaken() {
//		return partTaken;
//	}
//
//	public void setPartTaken(String partTaken) {
//		this.partTaken = partTaken;
//	}

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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getRecordFlag() {
		return recordFlag;
	}

	public void setRecordFlag(String recordFlag) {
		this.recordFlag = recordFlag;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public String getSequentialNumber() {
		return sequentialNumber;
	}

	public void setSequentialNumber(String sequentialNumber) {
		this.sequentialNumber = sequentialNumber;
	}

}
