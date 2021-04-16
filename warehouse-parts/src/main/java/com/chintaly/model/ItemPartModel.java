package com.chintaly.model;

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
 * @since 10/29/2018
 */

@Entity
@Table(name = "Item_Part")
public class ItemPartModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id_item_part", nullable = false)
	protected Integer idItemPart;

	@Column(name = "item_part_name", nullable = false)
	protected String itemPartName; // ` varchar(40) NOT NULL,

	@Column(name = "description", nullable = false)
	protected String description; // ` varchar(100) NOT NULL,

	@Column(name = "record_flag", nullable = false)
	protected String recordFlag; // ` varchar(1) NOT NULL DEFAULT '1'

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
