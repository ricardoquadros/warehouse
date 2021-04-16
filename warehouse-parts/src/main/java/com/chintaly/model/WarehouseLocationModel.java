package com.chintaly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse_location")
public class WarehouseLocationModel {

	@Id
	@GeneratedValue
	@Column(name = "id_warehouse_location", nullable = false)
	private Integer idWarehouseLocation; // `id_warehouse_location` int(11) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
	
	@Column(name = "id_warehouse", nullable = false)
	private Integer idWarehouse; // `id_warehouse` int(11)
	
	@Column(name = "description", nullable = false)
	private String description; // `description` varchar(100) NOT NULL,
	
	@Column(name = "record_flag", nullable = false)
	private String recordFlag; // `record_flag` varchar(1) NOT NULL DEFAULT '1'

	public WarehouseLocationModel() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRecordFlag() {
		return recordFlag;
	}

	public void setRecordFlag(String recordFlag) {
		this.recordFlag = recordFlag;
	}

}
