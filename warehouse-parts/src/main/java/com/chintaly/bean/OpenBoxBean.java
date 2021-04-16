package com.chintaly.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.chintaly.factory.ExecuteScript;

import com.chintaly.dao.OpenBoxDAO;
import com.chintaly.excel.OpenBoxGenExcel;
import com.chintaly.model.OpenBoxModel;
import com.chintaly.view.OpenBoxView;

/**
 * This Class is responsible for provide access to data(Data Access Object).
 * 
 * @author Ricardo Quadros.
 * @version 1.0
 * @since 09/01/2018
 */
// TODO: Create errors exceptions
// TODO: include Image

@ManagedBean
@ViewScoped
public class OpenBoxBean extends OpenBoxModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 993934980195138639L;

	private OpenBoxModel openBox;

	private ArrayList<OpenBoxView> openBoxViewList;

	private String openBoxSearch;

	public ArrayList<OpenBoxView> getOpenBoxViewList() { return openBoxViewList; }

	public Integer getIdOpenBox() { return openBox.getIdOpenBoxInventory(); }
	public String getOpenBoxSearch() { return this.openBoxSearch; }
	public void setOpenBoxSearch(String openBoxSearch) { this.openBoxSearch = openBoxSearch; }

	public void search(String openBoxSearch) {
		this.openBoxSearch = openBoxSearch;
		loadListOfItem();
	}
	
	public void printList(Integer report) {
		OpenBoxGenExcel pr = new OpenBoxGenExcel();

		try {
			if(report==1){
				loadListOfItem();
				pr.genOpenBoxAnalytic(openBoxViewList);
				
			} else if(report==2) {
				loadListOfItemAna(2);
				pr.genOpenBoxAnalyticParts(openBoxViewList);
				
			} else if(report==3) {
				loadListOfItemAna(3);
				pr.genOpenBoxAnalyticBoxes(openBoxViewList);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loadListOfItem();
	}
	
	/**
	 * This Annotation says the following method will executed as soon as the
	 * ManagedBean is called.
	 */
	@PostConstruct
	public void onCreate() {

		openBoxViewList = new ArrayList<OpenBoxView>();

		openBox = new OpenBoxModel();

		/**
		 * Calling the Method loadListOfItem.
		 */
		loadListOfItem();
	}

	/**
	 * The aim of the method is insert new item in database.
	 * 
	 * @return Redirect to the home page.
	 * @throws IOException
	 *             IOException.
	 */
	public String insertItem() throws IOException {

		openBox.setApprovedBy(approvedBy);
		openBox.setDateCheckIn(dateCheckIn);
		openBox.setDateCheckOut(dateCheckOut);
		//openBox.setIdImage(1);
		openBox.setIdItem(idItem);
		openBox.setIdItemPart(idItemPart);
		openBox.setIdOpenBoxInventory(idOpenBoxInventory);
		openBox.setIdWarehouse(idWarehouse);
		openBox.setIdWarehouseLocation(idWarehouseLocation);
		openBox.setNotes(notes);
		openBox.setPackingSlip(packingSlip);
		//openBox.setPartTaken(partTaken);
		openBox.setPoNumber(poNumber);
		openBox.setQty(qty);
		openBox.setRecordFlag("1");

		OpenBoxDAO.getInstance().insertOpenBox(openBox);

		loadListOfItem();
		return "item/OpenBoxList";
	}

	/**
	 * The purpose of the method is delete one item in database.
	 * 
	 * @param idItem
	 *            This is primary key of the user in question.
	 * @return Redirect to the home page.
	 */
	public String deleteItem(Integer idOpenBoxInventory) {

		//OpenBoxModel openBoxLoad = OpenBoxDAO.getInstance().selectItemByID(idOpenBoxInventory);

		openBox = new OpenBoxModel();
		openBox.setApprovedBy(approvedBy);
		openBox.setDateCheckIn(dateCheckIn);
		openBox.setDateCheckOut(dateCheckOut);
		//openBox.setIdImage(1);
		openBox.setIdItem(idItem);
		openBox.setIdItemPart(idItemPart);
		openBox.setIdOpenBoxInventory(idOpenBoxInventory);
		openBox.setIdWarehouse(idWarehouse);
		openBox.setIdWarehouseLocation(idWarehouseLocation);
		openBox.setNotes(notes);
		openBox.setPackingSlip(packingSlip);
		//openBox.setPartTaken(partTaken);
		openBox.setPoNumber(poNumber);
		openBox.setQty(qty);
		openBox.setRecordFlag("0");

		//OpenBoxDAO.getInstance().(openBox);

		loadListOfItem();
		return "item/OpenBoxList";
	}

	/**
	 * The objective of the method is update one Item.
	 * 
	 * @param idItem
	 *            This parameter is the primary key of the item.
	 * @return Redirect to the home page.
	 */
	public String updateItem(Integer idOpenBoxInventory) {

		loadListOfItem();
		return "item/OpenBoxList";
	}

	/**
	 * This parameter is the primary key of the Open Box.
	 * 
	 * @param Integer idOpenBoxInventory
	 * 
	 */
	public void loadItemForUpdate(Integer idOpenBoxInventory) {

		/**
		 * Calling the function JS "showModal()" of the page XHTML.
		 */
		//PrimeFaces.current().executeScript("showModal();");
		new ExecuteScript();

	}

	/**
	 * The aim of the method is to load {@link #listItem} with the data from the
	 * table Item.
	 */
	public void loadListOfItemAna(int choice) {

		if(choice==2) {
			openBoxViewList = OpenBoxDAO.getInstance().openBoxPartsList(openBoxSearch);
			
		} else if(choice==3) {
			openBoxViewList = OpenBoxDAO.getInstance().openBoxQuantityList(openBoxSearch);
		}
	}

	/**
	 * The aim of the method is to load {@link #listItem} with the data from the
	 * table Item.
	 */
	public void loadListOfItem() {

		openBoxViewList = OpenBoxDAO.getInstance().openBoxGeneralList(openBoxSearch);
		
	}

}
