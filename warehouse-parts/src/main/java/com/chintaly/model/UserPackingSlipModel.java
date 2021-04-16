package com.chintaly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Packingslip")
public class UserPackingSlipModel {

	@Id
	@GeneratedValue
	@Column(name = "id_user_packingSlip", nullable = false)
	protected Integer idUserPackingSlip; // `id_user_packingslip` int(11) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,

	@Column(name = "user_name", nullable = false)
	protected String userName; // `user_name` varchar(100) NOT NULL,

	@Column(name = "record_flag", nullable = false)
	protected String recordFlag; // `record_flag` varchar(1) NOT NULL DEFAULT '1'
	
	public UserPackingSlipModel() {
	}

	public Integer getIdUserPackingSlip() {
		return idUserPackingSlip;
	}

	public void setIdUserPackingSlip(Integer idUserPackingSlip) {
		this.idUserPackingSlip = idUserPackingSlip;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRecordFlag() {
		return recordFlag;
	}

	public void setRecordFlag(String recordFlag) {
		this.recordFlag = recordFlag;
	}

}
