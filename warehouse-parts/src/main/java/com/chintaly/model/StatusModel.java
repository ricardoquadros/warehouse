package com.chintaly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Status")
public class StatusModel {

	@Id
	@GeneratedValue
	@Column(name = "id_status", nullable = false)
	private Integer idStatus; // `id_status` int(11) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
	
	@Column(name = "status", nullable = false)
	private String status; // `status` varchar(20) NOT NULL,
	
	@Column(name = "description", nullable = false)
	private String description; // `description` varchar(100) NOT NULL,
	
	@Column(name = "record_flag", nullable = false)
	private String recordFlag; // `record_flag` varchar(1) NOT NULL DEFAULT '1'

	public StatusModel() {
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
