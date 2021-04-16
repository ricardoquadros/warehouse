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
@Table(name = "Packingslip_History")
public class PackingSlipModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id_packingslip_history", nullable = false)
	protected Integer idPartHistory; // `id_part_history` int(11) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,

	@Column(name = "id_warehouse_location", nullable = false)
	protected Integer idWarehouseLocation; // `id_warehouse_location` int(11) NOT NULL,

	@Column(name = "id_warehouse", nullable = false)
	protected Integer idWarehouse; // `id_warehouse` int(11) NOT NULL,
	
	@Column(name = "id_user_packingSlip", nullable = false)
	protected Integer idUserPackingSlip; // `id_user_packingslip` int(11) NOT NULL DEFAULT 0,
	
	@Column(name = "id_item", nullable = false)
	protected Integer idItem; // `id_item` int(11) NOT NULL,
	
	@Column(name = "id_item_part", nullable = false)
	protected Integer idItemPart; // `id_item_part` int(11) NOT NULL,
	
	@Column(name = "id_item_inventory", nullable = false)
	protected Integer idItemInventory; // `id_item_inventory`      INT(11) NOT NULL DEFAULT 0,

	@Column(name = "id_item_part_inventory", nullable = false)
	protected Integer idItemPartInventory; // `id_item_part_inventory` INT(11) NOT NULL,

	@Column(name = "id_open_box_inventory", nullable = false)
	protected Integer idOpenBoxInventory; //`id_open_box_inventory`  INT(11) NOT NULL,
	  
	@Column(name = "id_status", nullable = false)
	protected Integer idStatus; // `id_status` int(11) NOT NULL,
	
	@Column(name = "qty_stock", nullable = false)
	protected BigDecimal qtyStockBefore; // 'qty_stock_before` int(11) NOT NULL DEFAULT 0,
	
	@Column(name = "qty", nullable = false)
	protected BigDecimal qtyMove; // `qty_move` int(11) NOT NULL DEFAULT 0,
	
	@Column(name = "date_checkin", nullable = false)
	protected Date dateCheckIn; // `date_checkin` DATE NOT NULL DEFAULT 0,
	
	@Column(name = "date_checkout", nullable = false)
	protected Date dateCheckOut; // `date_checkout` DATE NOT NULL DEFAULT 0,
	
	@Column(name = "part_taken", nullable = false)
	protected String partTaken; // `part_taken` varchar(250) NOT NULL,
	
	@Column(name = "packingslip", nullable = false)
	protected String packingSlip; // `packingslip` varchar(15) NOT NULL,
	
	@Column(name = "approved_by", nullable = false)
	protected String approvedBy; // `approved_by` varchar(20) NOT NULL,
	
	@Column(name = "notes", nullable = false)
	protected String notes; // `notes` varchar(250) NOT NULL,
	
	@Column(name = "bill_ship", nullable = false)
	protected String billShip; // `bill_ship` varchar(250) NOT NULL,
	
	@Column(name = "po_number", nullable = false)
	protected String poNumber; // `po_number` varchar(15) NOT NULL,
	
	@Column(name = "po_number_invoice", nullable = false)
	protected String poNumberInvoice; // `po_number_invoice` varchar(30) NOT NULL,
	
	@Column(name = "sequential_number", nullable = false)
	protected String sequentialNumber; // `sequential_number` varchar(30) NOT NULL,
	
	@Column(name = "dimension", nullable = false)
	protected String dimension; // `dimension`   VARCHAR(15) NOT NULL DEFAULT ' ',

	@Column(name = "weight", nullable = false)
	protected String weight; // `weight`                 VARCHAR(15) NOT NULL DEFAULT ' ',

	@Column(name = "freight", nullable = false)
	protected String freight; // `freight`                VARCHAR(25) NOT NULL DEFAULT ' ',

	@Column(name = "email_sent_count", nullable = false)
	protected Integer emailSentCount; // `email_sent_count`       INT(3) NOT NULL DEFAULT 0,

	@Column(name = "record_flag", nullable = false)
	protected String recordFlag; // `record_flag` varchar(1) NOT NULL DEFAULT '1'

	public PackingSlipModel() {
	}

	public Integer getIdPartHistory() {
		return idPartHistory;
	}

	public void setIdPartHistory(Integer idPartHistory) {
		this.idPartHistory = idPartHistory;
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

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public Integer getIdItemInventory() {
		return idItemInventory;
	}

	public void setIdItemInventory(Integer idItemInventory) {
		this.idItemInventory = idItemInventory;
	}

	public Integer getIdItemPartInventory() {
		return idItemPartInventory;
	}

	public void setIdItemPartInventory(Integer idItemPartInventory) {
		this.idItemPartInventory = idItemPartInventory;
	}

	public Integer getIdOpenBoxInventory() {
		return idOpenBoxInventory;
	}

	public void setIdOpenBoxInventory(Integer idOpenBoxInventory) {
		this.idOpenBoxInventory = idOpenBoxInventory;
	}

	public BigDecimal getQtyStockBefore() {
		return qtyStockBefore;
	}

	public void setQtyStockBefore(BigDecimal qtyStockBefore) {
		this.qtyStockBefore = qtyStockBefore;
	}

	public BigDecimal getQtyMove() {
		return qtyMove;
	}

	public void setQtyMove(BigDecimal qtyMove) {
		this.qtyMove = qtyMove;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public void setRecordFlag(String recordFlag) {
		this.recordFlag = recordFlag;
	}

	public Integer getIdUserPackingSlip() {
		return idUserPackingSlip;
	}

	public void setIdUserPackingSlip(Integer idUserPackingSlip) {
		this.idUserPackingSlip = idUserPackingSlip;
	}

}
