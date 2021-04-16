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

/**
 * This Class is responsible for provide access to data(Data Access Object).
 * 
 * @author Ricardo Quadros.
 * @version 1.0
 * @since 09/01/2018
 */
// TODO: include Warehouse, Warehouse_Location, Image, Item_part

@Entity
@Table(name = "Item_Part_Inventory")
public class ItemPartInventoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id_item_part_inventory", nullable = false)
	protected Integer idItemPartInventory;

	@Column(name = "id_warehouse", nullable = false)
	protected Integer idWarehouse;

	@Column(name = "id_warehouse_location", nullable = false)
	protected Integer idWarehouseLocation;

	@Column(name = "id_item", nullable = false)
	protected Integer idItem;

	@Column(name = "id_item_part", nullable = false)
	protected Integer idItemPart;

	@Column(name = "qty", nullable = false)
	protected BigDecimal qty;

	@Column(name = "date_checkin", nullable = false)
	protected Date date_last_in;

	@Column(name = "date_checkout", nullable = false)
	protected Date date_last_out;

	@Column(name = "notes", nullable = false)
	protected String notes;

	@Column(name = "sequential_number", nullable = false)
	protected String sequentialNumber;

	@Column(name = "record_flag", nullable = false)
	protected String recordFlag;

	public ItemPartInventoryModel() {
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

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty2) {
		this.qty = qty2;
	}

	public Date getDate_last_in() {
		return date_last_in;
	}

	public void setDate_last_in(Date date_last_in) {
		this.date_last_in = date_last_in;
	}

	public Date getDate_last_out() {
		return date_last_out;
	}

	public void setDate_last_out(Date date_last_out) {
		this.date_last_out = date_last_out;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getRecordFlag() {
		return recordFlag;
	}

	public void setRecordFlag(String recordFlag) {
		this.recordFlag = recordFlag;
	}

	public String getSequentialNumber() {
		return sequentialNumber;
	}

	public void setSequentialNumber(String sequentialNumber) {
		this.sequentialNumber = sequentialNumber;
	}

}
