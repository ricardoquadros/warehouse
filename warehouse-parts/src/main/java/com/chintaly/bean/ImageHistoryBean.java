package com.chintaly.bean;

import java.io.Serializable;
import java.util.ArrayList;

import com.chintaly.dao.ImageHistoryDAO;
import com.chintaly.model.ImageHistoryModel;

public class ImageHistoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7603780481121214517L;
	
	private ArrayList<ImageHistoryModel> imageHistoryList;

	public ArrayList<ImageHistoryModel> getImageHistoryList() {
		return imageHistoryList;
	}
	public void setImageHistoryList(ArrayList<ImageHistoryModel> imageHistoryList) {
		this.imageHistoryList = imageHistoryList;
	}

	public void loadImagesPackingslip(String packingSlipNumber) {

		this.imageHistoryList = ImageHistoryDAO.getInstance().selectImagePackingSlip(packingSlipNumber);
		
	}

}
