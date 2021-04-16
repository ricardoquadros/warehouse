package com.chintaly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "image_history")
public class ImageHistoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id_image_history", nullable = false)
	Integer idImageHistory;

	@Column(name = "id_warehouse_location", nullable = false)
	Integer idWarehouseLocation;

	@Column(name = "id_warehouse", nullable = false)
	Integer idWarehouse;

	@Column(name = "id_item", nullable = false)
	Integer idItem;

	@Column(name = "id_item_part", nullable = false)
	Integer idItemPart;

	@Column(name = "packingslip", nullable = false)
	String packingslipNumber;

	@Column(name = "image_path_folder", nullable = false)
	String imagePathFolder;

	@Column(name = "image_name", nullable = false)
	String imageName;

	@Column(name = "image_description", nullable = false)
	String imageDescription;

	@Lob
	@Column(name = "image_data", nullable = false)
	byte[] imageData;

	@Column(name = "date_checkin", nullable = false)
	Date dateCheckIn;

	@Column(name = "record_flag", nullable = false)
	String recordFlag;

	public ImageHistoryModel() {

	}

	public Integer getIdImageHistory() {
		return idImageHistory;
	}

	public void setIdImageHistory(Integer idImageHistory) {
		this.idImageHistory = idImageHistory;
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

	public String getPackingslipNumber() {
		return packingslipNumber;
	}

	public void setPackingslipNumber(String packingslipNumber) {
		this.packingslipNumber = packingslipNumber;
	}

	public String getImagePathFolder() {
		return imagePathFolder;
	}

	public void setImagePathFolder(String imagePathFolder) {
		this.imagePathFolder = imagePathFolder;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public Date getDateCheckIn() {
		return dateCheckIn;
	}

	public void setDateCheckIn(Date dateCheckIn) {
		this.dateCheckIn = dateCheckIn;
	}

	public String getRecordFlag() {
		return recordFlag;
	}

	public void setRecordFlag(String recordFlag) {
		this.recordFlag = recordFlag;
	}
	
}
