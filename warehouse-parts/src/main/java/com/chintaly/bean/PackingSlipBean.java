package com.chintaly.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import com.chintaly.dao.ImageHistoryDAO;
import com.chintaly.dao.ItemDAO;
import com.chintaly.dao.ItemPartDAO;
import com.chintaly.dao.ItemPartInventoryDAO;
import com.chintaly.dao.OpenBoxDAO;
import com.chintaly.dao.PackingSlipDAO;
import com.chintaly.dao.StatusDAO;
import com.chintaly.main.Constant;
import com.chintaly.main.Main;
import com.chintaly.model.ItemPartInventoryModel;
import com.chintaly.model.OpenBoxModel;
import com.chintaly.model.PackingSlipModel;
import com.chintaly.view.PackingSlipView;

/**
 * This Class is responsible for provide access to data(Data Access Object).
 * 
 * @author Ricardo Quadros
 * @version 1.0
 * @since 11/10/2018
 * 
 */

@ManagedBean
@ViewScoped
public class PackingSlipBean extends PackingSlipModel implements Serializable {

	private static final long serialVersionUID = 200368749572977211L;

	private String showPage;

	private String searchPackingSlip;

	// packing slip temporary record fields
	private String psWarehouse;
	private String psItemName;
	private String psItemPartName;
	private String psLocationName;
	private String psPackingSlipNumber;
	private String psNotes;
	private String psBillShip;
	private String psAuthorization;
	private String psStatus;
	private String psInvoice;
	private String psSequential;
	private String psPoNumber;
	private String psOpenBox;
	private BigDecimal psQty;
	private String psImage;
	private String psUserName;
	private String psDimension;
	private String psWeight;
	private String psFreight;
	
	private String imgSrcPath;

	private PackingSlipModel packingSlip;

	private ArrayList<PackingSlipView> packingSlipList;

	private List<String> imageHistoryList;

	public List<String> getImageHistoryList() {
		return imageHistoryList;
	}

	public void setImageHistoryList(List<String> imageHistoryList) {
		this.imageHistoryList = imageHistoryList;
	}

	public String getImgSrcPath() {
		return imgSrcPath;
	}

	public void setImgSrcPath(String imgSrcPath) {
		this.imgSrcPath = imgSrcPath;
	}

	public ArrayList<PackingSlipView> getPackingSlipList() {
		return packingSlipList;
	}

	public String getSearchPackingSlip() {
		return this.searchPackingSlip;
	}

	public void setSearchPackingSlip(String searchPackingSlip) {
		this.searchPackingSlip = searchPackingSlip;
	}

	public void search(String searchPackingSlip) {
		this.searchPackingSlip = searchPackingSlip;
		loadPackingSlipList();
	}

	public String getPsImage() {
		return psImage;
	}

	public void setPsImage(String psImage) {
		this.psImage = psImage;
	}

	public String getPsWarehouse() {
		return psWarehouse;
	}

	public void setPsWarehouse(String psWarehouse) {
		this.psWarehouse = psWarehouse;
	}

	public String getPsItemName() {
		return psItemName;
	}

	public void setPsItemName(String psItemName) {
		this.psItemName = psItemName;
	}

	public String getPsItemPartName() {
		return psItemPartName;
	}

	public void setPsItemPartName(String psItemPartName) {
		this.psItemPartName = psItemPartName;
	}

	public String getPsLocationName() {
		return psLocationName;
	}

	public void setPsLocationName(String psLocationName) {
		this.psLocationName = psLocationName;
	}

	public String getPsPackingSlipNumber() {
		return psPackingSlipNumber;
	}

	public void setPsPackingSlipNumber(String psPackingSlipNumber) {
		this.psPackingSlipNumber = psPackingSlipNumber;
	}

	public String getPsNotes() {
		return psNotes;
	}

	public void setPsNotes(String psNotes) {
		this.psNotes = psNotes;
	}

	public String getPsBillShip() {
		return psBillShip;
	}

	public void setPsBillShip(String psBillShip) {
		this.psBillShip = psBillShip;
	}

	public String getPsAuthorization() {
		return psAuthorization;
	}

	public void setPsAuthorization(String psAuthorization) {
		this.psAuthorization = psAuthorization;
	}

	public String getPsStatus() {
		return psStatus;
	}

	public void setPsStatus(String psStatus) {
		this.psStatus = psStatus;
	}

	public String getPsInvoice() {
		return psInvoice;
	}

	public void setPsInvoice(String psInvoice) {
		this.psInvoice = psInvoice;
	}

	public String getPsSequential() {
		return psSequential;
	}

	public void setPsSequential(String psSequential) {
		this.psSequential = psSequential;
	}

	public String getPsPoNumber() {
		return psPoNumber;
	}

	public void setPsPoNumber(String psPoNumber) {
		this.psPoNumber = psPoNumber;
	}

	public BigDecimal getPsQty() {
		return psQty;
	}

	public void setPsQty(BigDecimal psQty) {
		this.psQty = psQty;
	}

	public String getPsOpenBox() {
		return psOpenBox;
	}

	public void setPsOpenBox(String psOpenBox) {
		this.psOpenBox = psOpenBox;
	}

	public String getPsUserName() {
		return psUserName;
	}

	public void setPsUserName(String psUserName) {
		this.psUserName = psUserName;
	}

	public String getPsDimension() {
		return psDimension;
	}

	public void setPsDimension(String psDimension) {
		this.psDimension = psDimension;
	}

	public String getPsWeight() {
		return psWeight;
	}

	public void setPsWeight(String psWeight) {
		this.psWeight = psWeight;
	}

	public String getPsFreight() {
		return psFreight;
	}

	public void setPsFreight(String psFreight) {
		this.psFreight = psFreight;
	}

	/**
	* Return the id of the warehouse location.
	* <p>
	* Still using a constant has to be changed to get from the DAO class.
	*
	* @param Location description from where the item was taken (Parts, Warehouse, Open Box)
	*/
	public Integer getIdLocation(String psLocaString) {

		Integer idLocation = 0;

		if (psLocationName.equals("WAREHOUSE")) {
			idLocation = Constant.WAREHOUSE;
		} else if (psLocationName.equals("PHOTO ROOM")) {
			idLocation = Constant.PHOTO_ROOM;
		} else if (psLocationName.equals("PARTS")) {
			idLocation = Constant.PARTS;
		} else if (psLocationName.equals("OPEN BOX")) {
			idLocation = Constant.OPEN_BOX;
		} else if (psLocationName.equals("SMALL ROOM")) {
			idLocation = Constant.SMALL_ROOM;
		}

		return idLocation;
	}

	/**
	* This Annotation says the following method will executed as soon as the
	* ManagedBean is called.
	*/
	@PostConstruct
	public void onCreate() {

		showPage = Main.isAdmin() ? Constant.PACKING_SLIP_LIST_ADM : Constant.PACKING_SLIP_LIST_USR;

		packingSlip = new PackingSlipModel();

		packingSlipList = new ArrayList<PackingSlipView>();

		loadPackingSlipList();
	}

	/**
	 * This method will load all packing slip records to an array list
	 */
	//TODO Needs to be reviewed too many records will be returned
	public void loadPackingSlipList() {

		packingSlipList = new ArrayList<PackingSlipView>();

		packingSlipList = PackingSlipDAO.getInstance().selectPackingSlip(searchPackingSlip);

	}

	public String showImages(String packingSlipNumber) {

		setImageHistoryList(ImageHistoryDAO.getInstance().selectImageListPackingSlip(packingSlipNumber));
		
		/**
		 * Calling the function JS "showModal()" of the page XHTML.
		 */
		PrimeFaces.current().executeScript("showImages();");
		
		return "";
	}

	public void prepareNewItem() {

		packingSlip = new PackingSlipModel();

		/**
		 * Calling the function JS "showModal()" of the page XHTML.
		 */
		PrimeFaces.current().executeScript("showModal();");
		
	}

	public String insertRecordPackingSlip() {

		ItemPartInventoryModel itemPartInv = new ItemPartInventoryModel();
		OpenBoxModel openBoxInv = new OpenBoxModel();

		if(psSequential.trim().length() == 0) {
			psSequential = "0000000-000000";
		}
		
		packingSlip.setApprovedBy(psAuthorization);
		packingSlip.setBillShip(psBillShip);
		packingSlip.setDateCheckIn(new Date());
		packingSlip.setDateCheckOut(new Date());
		packingSlip.setIdWarehouse(Constant.WAREHOUSE_ID);
		packingSlip.setIdWarehouseLocation(getIdLocation(psLocationName));
		packingSlip.setIdItem(ItemDAO.getInstance().selectItemByName(psItemName));
		packingSlip.setIdItemPart(ItemPartDAO.getInstance().selectItemPartByName(psItemPartName));
		packingSlip.setIdStatus(StatusDAO.getInstance().selectStatusByName(psStatus).getIdStatus());
		packingSlip.setNotes(psNotes);
		packingSlip.setPackingSlip(psPackingSlipNumber);
		packingSlip.setPartTaken(psItemPartName);
		packingSlip.setPoNumber(psPoNumber);
		packingSlip.setPoNumberInvoice(psInvoice);
		packingSlip.setQtyMove(psQty);
		packingSlip.setQtyStockBefore(psQty);
		packingSlip.setSequentialNumber(psSequential);
		packingSlip.setRecordFlag("1");
		packingSlip.setIdUserPackingSlip(idUserPackingSlip);
		packingSlip.setDimension(psDimension);
		packingSlip.setWeight(psWeight);
		packingSlip.setFreight(psFreight);
		packingSlip.setEmailSentCount(0);
		packingSlip.setIdUserPackingSlip(1);

		itemPartInv = ItemPartInventoryDAO.getInstance().selectItemPartInventory(packingSlip);
		openBoxInv = OpenBoxDAO.getInstance().selectOpenBoxInventory(packingSlip);

		if (itemPartInv != null) {
			itemPartInv.setQty(itemPartInv.getQty().add(packingSlip.getQtyMove()));

			ItemPartInventoryDAO.getInstance().updateItemPartInventory(itemPartInv);
		}
		if (openBoxInv != null && packingSlip.getApprovedBy().length() > 0
				&& packingSlip.getIdWarehouseLocation() == Constant.OPEN_BOX) {

			BigDecimal qty = openBoxInv.getQty();

			openBoxInv.setQty(packingSlip.getQtyMove().add(qty));
			OpenBoxDAO.getInstance().updateOpenBox(openBoxInv);
		}

		if (openBoxInv == null && packingSlip.getApprovedBy().length() > 0
				&& packingSlip.getIdWarehouseLocation() == Constant.OPEN_BOX) {

			openBoxInv = new OpenBoxModel();

			openBoxInv.setApprovedBy(packingSlip.getApprovedBy());
			openBoxInv.setDateCheckIn(packingSlip.getDateCheckIn());
			openBoxInv.setDateCheckOut(packingSlip.getDateCheckOut());
			openBoxInv.setIdItemInventory(0);
			openBoxInv.setIdItem(packingSlip.getIdItem());
			openBoxInv.setIdItemPart(packingSlip.getIdItemPart());
			openBoxInv.setIdStatus(Constant.WAITING_ORDER);
			openBoxInv.setIdWarehouse(packingSlip.getIdWarehouse());
			openBoxInv.setIdWarehouseLocation(packingSlip.getIdWarehouseLocation());
			openBoxInv.setNotes(packingSlip.getNotes());
			openBoxInv.setPackingSlip(packingSlip.getPackingSlip());
			openBoxInv.setPoNumber(packingSlip.getPoNumber());
			openBoxInv.setQty(packingSlip.getQtyMove());
			openBoxInv.setSequentialNumber(packingSlip.getSequentialNumber());
			openBoxInv.setRecordFlag("1");

			OpenBoxDAO.getInstance().insertOpenBox(openBoxInv);

		}

		if (itemPartInv == null) {

			itemPartInv = new ItemPartInventoryModel();

			itemPartInv.setDate_last_in(packingSlip.getDateCheckIn());
			itemPartInv.setDate_last_out(packingSlip.getDateCheckOut());
			itemPartInv.setIdItem(packingSlip.getIdItem());
			itemPartInv.setIdItemPart(packingSlip.getIdItemPart());
			itemPartInv.setIdWarehouse(packingSlip.getIdWarehouse());
			itemPartInv.setIdWarehouseLocation(packingSlip.getIdWarehouseLocation());
			itemPartInv.setNotes(packingSlip.getNotes());
			itemPartInv.setQty(packingSlip.getQtyMove());
			itemPartInv.setSequentialNumber(packingSlip.getSequentialNumber());
			itemPartInv.setRecordFlag("1");

			ItemPartInventoryDAO.getInstance().insertItemPartInventory(itemPartInv);

		}

		itemPartInv = ItemPartInventoryDAO.getInstance().selectItemPartInventory(packingSlip);
		openBoxInv = OpenBoxDAO.getInstance().selectOpenBoxInventory(packingSlip);

		packingSlip.setIdItemInventory(0); // (idItemInventory);
		if (itemPartInv == null || itemPartInv.getIdItemPartInventory() == null) {
			packingSlip.setIdItemPartInventory(0);
		} else {
			packingSlip.setIdItemPartInventory(itemPartInv.getIdItemPartInventory());
		}
		if (openBoxInv == null || openBoxInv.getIdOpenBoxInventory() == null) {
			packingSlip.setIdOpenBoxInventory(0);
		} else {
			packingSlip.setIdOpenBoxInventory(openBoxInv.getIdOpenBoxInventory());
		}

		PackingSlipDAO.getInstance().insertPackingSlip(packingSlip);

		//loadPackingSlipList();

		// return "item/PackingSlipListEdit";
		return showPage;
	}

	public String deleteRecordPackingSlip(Integer IdPackingSlip) {

		//loadPackingSlipList();

		// return "item/PackingSlipListEdit";
		return showPage;
	}

	public String editRecordPackingSlip(Integer idPackingSlip) {

		PackingSlipModel packingSlipLoad = PackingSlipDAO.getInstance().selectPackingSlipById(idPackingSlip);

		packingSlip = new PackingSlipModel();
		packingSlip.setApprovedBy(packingSlipLoad.getApprovedBy());
		packingSlip.setBillShip(packingSlipLoad.getBillShip());
		packingSlip.setDateCheckIn(packingSlipLoad.getDateCheckIn());
		packingSlip.setDateCheckOut(packingSlipLoad.getDateCheckOut());
		packingSlip.setIdItem(packingSlipLoad.getIdItem());
		packingSlip.setIdItemPart(packingSlipLoad.getIdItemPart());
		packingSlip.setIdPartHistory(packingSlipLoad.getIdPartHistory());
		packingSlip.setIdStatus(packingSlipLoad.getIdStatus());
		packingSlip.setIdWarehouse(packingSlipLoad.getIdWarehouse());
		packingSlip.setIdWarehouseLocation(packingSlipLoad.getIdWarehouseLocation());
		packingSlip.setNotes(packingSlipLoad.getNotes());
		packingSlip.setPackingSlip(packingSlipLoad.getPackingSlip());
		packingSlip.setPartTaken(packingSlipLoad.getPartTaken());
		packingSlip.setPoNumber(packingSlipLoad.getPoNumber());
		packingSlip.setPoNumberInvoice(packingSlipLoad.getPoNumberInvoice());
		packingSlip.setQtyMove(packingSlipLoad.getQtyMove());
		packingSlip.setQtyStockBefore(packingSlipLoad.getQtyStockBefore());
		packingSlip.setSequentialNumber(packingSlipLoad.getSequentialNumber());
		packingSlip.setIdUserPackingSlip(packingSlipLoad.getIdUserPackingSlip());
		packingSlip.setRecordFlag("1");

		/**
		 * Calling the function JS "showModal()" of the page XHTML.
		 */
		// RequestContext.getCurrentInstance();
		//PrimeFaces.current().executeScript("showModal();");

		loadPackingSlipList();

		// return "item/PackingSlipListEdit";
		return showPage;
	}

}
