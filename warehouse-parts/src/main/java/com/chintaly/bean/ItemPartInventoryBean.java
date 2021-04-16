package com.chintaly.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import com.chintaly.dao.ItemPartInventoryDAO;
import com.chintaly.model.ItemPartInventoryModel;
import com.chintaly.model.ItemPartModel;
import com.chintaly.view.ItemPartInventoryView;

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
public class ItemPartInventoryBean extends ItemPartModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8450301003843235827L;

	private ItemPartInventoryModel itemPart;

	private ArrayList<ItemPartInventoryModel> itemPartInventoryList;
	private ArrayList<ItemPartInventoryView> itemPartInventoryViewList;

	private String itemPartSearch;

	public ArrayList<ItemPartInventoryModel> getItemPartInventoryList() {
		return itemPartInventoryList;
	}

	public ArrayList<ItemPartInventoryView> getItemPartInventoryViewList() {
		return itemPartInventoryViewList;
	}

	public Integer getIdItemPart() {
		return itemPart.getIdItemPart();
	}

	public String getItemPartSearch() {
		return this.itemPartSearch;
	}

	public void setItemPartSearch(String itemPartSearch) {
		this.itemPartSearch = itemPartSearch;
	}

	public void search(String itemPartSearch) {
		this.itemPartSearch = itemPartSearch;
		loadListOfItemPart();
		
	}

	/**
	 * This Annotation says the following method will executed as soon as the
	 * ManagedBean is called.
	 */
	@PostConstruct
	public void onCreate() {

		itemPartInventoryViewList = new ArrayList<ItemPartInventoryView>();

		itemPart = new ItemPartInventoryModel();

		/**
		 * Calling the Method loadListOfItem.
		 */
		loadListOfItemPart();
	}

	/**
	 * The aim of the method is insert new item in database.
	 * 
	 * @return Redirect to the home page.
	 * @throws IOException
	 *             IOException.
	 */
	public String insertItemPart() throws IOException {

		//ItemPartInventoryDAO.getInstance().insertItemPart(itemPart);

		loadListOfItemPart();
		return "item/ItemPartInventoryList";
	}

	/**
	 * The purpose of the method is delete one item in database.
	 * 
	 * @param idItem
	 *            This is primary key of the user in question.
	 * @return Redirect to the home page.
	 */
	public String deleteItemPart(Integer idItemPart) {

		// ItemDAO.getInstance().deleteItem(idItem);
		//ItemPartInventoryModel itemLoad = ItemPartInventoryDAO.getInstance().selectItemPartById(idItemPart);

//		itemPart = new ItemPartModel();
//		itemPart.setIdItemPart(idItemPart);
//		itemPart.setDescription(itemLoad.getDescription());
//		itemPart.setItemPartName(itemLoad.getItemPartName());
//		itemPart.setRecordFlag("0");

		//ItemPartInventoryDAO.getInstance().updateItemPart(itemPart);

		loadListOfItemPart();
		return "item/ItemPartInventoryList";
	}

	/**
	 * The objective of the method is update one Item.
	 * 
	 * @param idItem
	 *            This parameter is the primary key of the item.
	 * @return Redirect to the home page.
	 */
	public String updateItemPart(Integer idItem) {

//		itemPart.setIdItemPart(idItem);
//		itemPart.setDescription(description);
//		itemPart.setItemPartName(itemPartName);

//		ItemPartInventoryDAO.getInstance().updateItemPart(itemPart);

		loadListOfItemPart();
		return "item/ItemPartInventoryList";
	}

	/**
	 * 
	 * @param idItem
	 *            This parameter is the primary key of the Item.
	 */
	public void loadItemPartForUpdate(Integer idItem) {

		/**
		 * Calling the function JS "showModal()" of the page XHTML.
		 */
		PrimeFaces.current().executeScript("showModal();");
	}

	/**
	 * The aim of the method is to load {@link #listItem} with the data from the
	 * table Item.
	 */
	public void loadListOfItemPart() {

		itemPartInventoryViewList = ItemPartInventoryDAO.getInstance().selectAllItemPartInventory(itemPartSearch);

	}

}
