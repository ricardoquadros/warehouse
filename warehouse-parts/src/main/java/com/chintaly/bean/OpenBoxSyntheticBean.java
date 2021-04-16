package com.chintaly.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

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
public class OpenBoxSyntheticBean extends OpenBoxModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9004212220288787690L;

	private OpenBoxModel openBox;

	//private ArrayList<OpenBoxModel> openBoxList;
	private ArrayList<OpenBoxView> openBoxViewList;

	private String openBoxSearch;

	//public ArrayList<OpenBoxModel> getOpenBoxList() { return openBoxList; }
	public ArrayList<OpenBoxView> getOpenBoxViewList() { return openBoxViewList; }

	public Integer getIdOpenBox() { return openBox.getIdOpenBoxInventory(); }
	public String getOpenBoxSearch() { return this.openBoxSearch; }
	public void setOpenBoxSearch(String openBoxSearch) { this.openBoxSearch = openBoxSearch; }

	public void search(String openBoxSearch) {
		this.openBoxSearch = openBoxSearch;
		loadListOfItemSyn();
	}

	public void printList() {
		OpenBoxGenExcel pr = new OpenBoxGenExcel();

		try {
			pr.genOpenBoxSynthetic(openBoxViewList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		loadListOfItemSyn();
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

		loadListOfItemSyn();
		return "item/OpenBoxSyntheticList";
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

		loadListOfItemSyn();
		return "item/OpenBoxSyntheticList";
	}

	/**
	 * The objective of the method is update one Item.
	 * 
	 * @param idItem
	 *            This parameter is the primary key of the item.
	 * @return Redirect to the home page.
	 */
	public String updateItem(Integer idOpenBoxInventory) {

		loadListOfItemSyn();
		return "item/OpenBoxSyntheticList";
	}

	/**
	 * 
	 * @param idItem
	 *            This parameter is the primary key of the Item.
	 */
	public void loadItemForUpdate(Integer idOpenBoxInventory) {

		/**
		 * Calling the function JS "showModal()" of the page XHTML.
		 */
		PrimeFaces.current().executeScript("showModal();");
	}

	/**
	 * The aim of the method is to load {@link #listItem} with the data from the
	 * table Item.
	 */
	public void loadListOfItemSyn() {

		openBoxViewList = OpenBoxDAO.getInstance().openBoxQuantityList(openBoxSearch);
	}

	/**
	 * The aim of the method is to load {@link #listItem} with the data from the
	 * table Item.
	 */
	public void loadListOfItem() {

		openBoxViewList = OpenBoxDAO.getInstance().openBoxGeneralList(openBoxSearch);
	}

}
