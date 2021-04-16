package com.chintaly.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.chintaly.factory.SessionFactoryProvider;
import com.chintaly.main.Constant;
import com.chintaly.model.ItemModel;
import com.chintaly.model.ItemPartModel;
import com.chintaly.model.OpenBoxModel;
import com.chintaly.model.PackingSlipModel;
import com.chintaly.model.StatusModel;
import com.chintaly.view.OpenBoxView;

public class OpenBoxDAO {

	static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

	/**
	 * This is the instance of OpenBoxDAO.
	 */
	private static OpenBoxDAO instance;

	public static OpenBoxDAO getInstance() {

		if (instance == null) {
			instance = new OpenBoxDAO();
		}
		return instance;
	}

	/**
	 * This Method is responsible for insert new Item in table Item.
	 * 
	 * @param OpenBoxModel openBoxModel
	 */
	public void insertOpenBox(OpenBoxModel openBoxModel) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(openBoxModel);
		session.flush();

		transaction.commit();
		session.close();
	}

	/**
	 * This Method is responsible for insert new Item in table Item.
	 * 
	 * @param OpenBoxModel openBoxModel
	 */
	public void updateOpenBox(OpenBoxModel openBoxModel) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.update(openBoxModel);
		session.flush();

		transaction.commit();
		session.close();
	}

	/**
	 * This Method is responsible for delete one record in table Open_Box_Inventory.
	 * 
	 * @param idOpenBox This parameter is primary key of Open_Box_Inventory.
	 */
	public void deleteItem(long idOpenBox) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		OpenBoxModel openBox = (OpenBoxModel) session.get(OpenBoxModel.class, idOpenBox);

		session.delete(openBox);
		session.flush();

		transaction.commit();
		session.close();
	}

	/**
	 * This method is responsible for select all records related to an open box from stock or
	 * all records related to the specified item
	 * 
	 * @param String itemNameSearch
	 * @return This return is one ArrayList, loaded with query results
	 *
	 */ 
	public ArrayList<OpenBoxView> openBoxGeneralList(String itemNameSearch) {

		Calendar cal = Calendar.getInstance();

		ArrayList<OpenBoxView> openBoxViewList = new ArrayList<OpenBoxView>();
		OpenBoxView openBoxView;

		String sql;

		Session session = sessionFactory.openSession();

		sql = "SELECT I.ID_ITEM\n" + 
				"     , I.BAR_CODE\n" + 
				"     , I.ITEM_NAME\n" + 
				"     , I.DESCRIPTION\n" + 
				"     , I.COLOR\n" + 
				"     , I.PER_BOX\n" + 
				"     , I.DATE_REGISTER\n" + 
				"     , OB.ID_OPEN_BOX_INVENTORY\n" + 
				"     , OB.ID_WAREHOUSE\n" + 
				"     , OB.ID_WAREHOUSE_LOCATION\n" + 
				"     , OB.QTY\n" + 
				"     , OB.DATE_CHECKIN AS DTI\n" + 
				"     , OB.DATE_CHECKOUT AS DTO\n" + 
				"     , OB.NOTES\n" + 
				"     , OB.PACKINGSLIP\n" + 
				"     , OB.SEQUENTIAL_NUMBER\n" + 
				"     , OB.APPROVED_BY\n" + 
				"     , IP.ID_ITEM_PART\n" + 
				"     , IP.ITEM_PART_NAME\n" + 
				"     , OB.ID_STATUS\n" + 
				"  FROM ITEM AS I\n" + 
				"     , ITEM_PART AS IP\n" + 
				"     , OPEN_BOX_INVENTORY AS OB\n" + 
				"     , STATUS AS ST\n" + 
				" WHERE I.RECORD_FLAG = '1'\n" + 
				"   AND IP.RECORD_FLAG = '1'\n" + 
				"   AND OB.RECORD_FLAG = '1'\n" + 
				"   AND ST.RECORD_FLAG = '1'\n" + 
				"   AND ST.ID_STATUS = OB.ID_STATUS\n" + 
				"   AND IP.ID_ITEM_PART = OB.ID_ITEM_PART\n" + 
				"   AND OB.ID_ITEM = I.ID_ITEM\n";
		if (itemNameSearch != null) {
			sql = sql + " AND I.ITEM_NAME LIKE '" + itemNameSearch.trim().toUpperCase() + "%'\n";
		}
		sql += " ORDER BY I.ITEM_NAME ASC\n" + 
				"        , OB.SEQUENTIAL_NUMBER ASC\n" + 
				"        , IP.ITEM_PART_NAME ASC\n" + 
				"        , OB.PACKINGSLIP ASC\n" + 
				"        , OB.DATE_CHECKOUT DESC;\n" + 
				"";

		List<?> queryList = session.createNativeQuery(sql).getResultList();

		for (int i = 0; i < queryList.size(); i++) {
			Object[] obj = (Object[]) queryList.get(i);

			Integer idItem = (Integer) obj[0];
			String barCode = (String) obj[1];
			String itemName = (String) obj[2];
			String description = (String) obj[3];
			String color = (String) obj[4];
			Integer perBox = (Integer) obj[5];
			Date dateRegister = (Date) obj[6];

			Integer idOpenBoxInventory = (Integer) obj[7];
			Integer idWarehouse = (Integer) obj[8];
			Integer idWarehouseLocation = (Integer) obj[9];
			BigDecimal qty = (BigDecimal) obj[10];
			Date dateCheckIn = (Date) obj[11];
			Date dateCheckOut = (Date) obj[12];
			String notes = (String) obj[13];
			String packingSlip = (String) obj[14];
			String sequentialNumber = (String) obj[15];
			String approvedBy = (String) obj[16];

			Integer idItemPart = (Integer) obj[17];
			String itemPartName = (String) obj[18];

			Integer idStatus = (Integer) obj[19];

			StatusModel statusModel = new StatusModel();
			statusModel = StatusDAO.getInstance().selectStatusById(idStatus);

			cal.setTime(dateCheckOut);
			cal.add(Calendar.DATE, 1);
			dateCheckOut = cal.getTime();

			ItemModel itemModel = new ItemModel();
			itemModel.setBarCode(barCode);
			itemModel.setColor(color);
			itemModel.setDateRegister(dateRegister);
			itemModel.setDescription(description);
			itemModel.setIdItem(idItemPart);
			itemModel.setItemName(itemName);
			itemModel.setPerBox(perBox);
			itemModel.setRecordFlag("1");

			ItemPartModel itemPartModel = new ItemPartModel();
			itemPartModel.setItemPartName(itemPartName);
			itemPartModel.setIdItemPart(idItemPart);

			OpenBoxModel openBoxModel = new OpenBoxModel();
			openBoxModel.setDateCheckIn(dateCheckIn);
			openBoxModel.setDateCheckOut(dateCheckOut);
			openBoxModel.setIdItem(idItem);
			openBoxModel.setIdOpenBoxInventory(idOpenBoxInventory);
			openBoxModel.setIdItemPart(idItemPart);
			openBoxModel.setIdWarehouse(idWarehouse);
			openBoxModel.setIdWarehouseLocation(idWarehouseLocation);
			openBoxModel.setNotes(notes);
			openBoxModel.setQty(qty);
			openBoxModel.setRecordFlag("1");
			openBoxModel.setPackingSlip(packingSlip);
			openBoxModel.setSequentialNumber(sequentialNumber);
			openBoxModel.setIdStatus(idStatus);

			openBoxView = new OpenBoxView();
			openBoxView.setBarCode(barCode);
			openBoxView.setColor(color);
			openBoxView.setDateCheckIn(dateCheckIn);
			openBoxView.setDateCheckOut(dateCheckOut);
			openBoxView.setDateRegister(dateRegister);
			openBoxView.setDescription(description);
			openBoxView.setIdItem(idItem);
			openBoxView.setItemName(itemName);
			openBoxView.setIdItemPart(idItemPart);
			openBoxView.setIdWarehouse(idWarehouse);
			openBoxView.setItemPartName(itemPartName);
			openBoxView.setPerBox(perBox);
			openBoxView.setQty(qty);
			openBoxView.setApprovedBy(approvedBy);
			openBoxView.setPartTaken(itemPartName);
			openBoxView.setSequentialNumber(sequentialNumber);
			openBoxView.setDescStatus(statusModel.getDescription());
			openBoxView.setPackingSlip(packingSlip);

			openBoxViewList.add(openBoxView);

		}

		session.close();

		return openBoxViewList;
	}

	/**
	 * This method is responsible for select all item in table Item and count the
	 * number of parts used for each item in table open_box_inentory
	 * 
	 * @return This return is one ArrayList of ItemModel, loaded with query results
	 *         to the Item table.
	 */
	public ArrayList<OpenBoxView> openBoxPartsList(String itemNameSearch) {

		ArrayList<OpenBoxView> openBoxViewList = new ArrayList<OpenBoxView>();
		OpenBoxView openBoxView;

		String sql;

		Session session = sessionFactory.openSession();

		sql = "SELECT obtmp.id_item\n" 
				+ "     , I.item_name\n" 
				+ "     , obtmp.id_item_part\n"
				+ "     , IP.item_part_name\n" 
				+ "     , obtmp.qty\n" 
				+ "     , obtmp.date_checkout\n"
				+ "  FROM ITEM AS I \n" 
				+ "     , ITEM_PART AS IP \n" 
				+ "     , (SELECT I.ID_ITEM\n"
				+ "             , IP.ID_ITEM_PART\n" 
				+ "             , SUM( OB.QTY ) AS QTY\n"
				+ "             , MAX( ob.date_checkout) AS date_checkout\n" 
				+ "          FROM ITEM AS I\n"
				+ "             , ITEM_PART AS IP\n" 
				+ "             , OPEN_BOX_INVENTORY AS OB\n"
				+ "         WHERE I.RECORD_FLAG = '1'\n" 
				+ "           AND IP.RECORD_FLAG = '1'\n"
				+ "           AND OB.RECORD_FLAG = '1'\n" 
				+ "           AND IP.ID_ITEM_PART = OB.ID_ITEM_PART\n"
				+ "           AND OB.ID_ITEM = I.ID_ITEM\n" 
				+ "           AND OB.ID_STATUS = " + Constant.WAITING_ORDER + "\n";

		if (itemNameSearch != null) {
			sql += "           AND I.ITEM_NAME LIKE '" + itemNameSearch.trim().toUpperCase() + "%'\n";
		}

		sql += "         GROUP BY I.ID_ITEM\n" 
			+ "                , IP.ID_ITEM_PART) AS obtmp\n"
			+ " WHERE i.record_flag = '1'\n" 
			+ "   and ip.record_flag = '1'\n"
			+ "   and obtmp.id_item = i.id_item\n" 
			+ "   and obtmp.id_item_part = ip.id_item_part\n"
			+ " ORDER BY I.ITEM_NAME\n" 
			+ "        , IP.ITEM_PART_NAME;\n";

		List<?> queryList = session.createNativeQuery(sql).getResultList();

		for (int i = 0; i < queryList.size(); i++) {
			Object[] obj = (Object[]) queryList.get(i);

			Integer idItem = (Integer) obj[0];
			String itemName = (String) obj[1];

			Integer idItemPart = (Integer) obj[2];
			String itemPartName = (String) obj[3];

			BigDecimal qty = (BigDecimal) obj[4];

			Date dateCheckOut = (Date) obj[5];

			Integer idStatus = Constant.WAITING_ORDER;

			ItemModel itemModel = new ItemModel();
			itemModel.setIdItem(idItemPart);
			itemModel.setItemName(itemName);
			itemModel.setRecordFlag("1");

			ItemPartModel itemPartModel = new ItemPartModel();
			itemPartModel.setItemPartName(itemPartName);
			itemPartModel.setIdItemPart(idItemPart);

			OpenBoxModel openBoxModel = new OpenBoxModel();
			openBoxModel.setIdItem(idItem);
			openBoxModel.setIdItemPart(idItemPart);
			openBoxModel.setQty(qty);
			openBoxModel.setIdStatus(idStatus);
			openBoxModel.setDateCheckOut(dateCheckOut);

			openBoxView = new OpenBoxView();
			openBoxView.setIdItem(idItem);
			openBoxView.setItemName(itemName);
			openBoxView.setIdItemPart(idItemPart);
			openBoxView.setQty(qty);
			openBoxView.setPartTaken(itemPartName);
			openBoxView.setItemPartName(itemPartName);
			openBoxView.setDateCheckOut(dateCheckOut);

			openBoxViewList.add(openBoxView);

		}

		session.close();

		return openBoxViewList;
	}

	/**
	 * This method is responsible for select all item in table Item and count the
	 * number of parts used for each item in table open_box_inentory
	 * 
	 * @return This return is one ArrayList of ItemModel, loaded with query results
	 *         to the Item table.
	 */
	public ArrayList<OpenBoxView> openBoxQuantityList(String itemNameSearch) {

		ArrayList<OpenBoxView> openBoxViewList = new ArrayList<OpenBoxView>();
		OpenBoxView openBoxView;

		String sql;

		Session session = sessionFactory.openSession();

		sql = "SELECT ID_ITEM\n" + 
				"     , ITEM_NAME\n" + 
				"     , COUNT(1) AS QTD\n" + 
				"  FROM (SELECT OBI.ID_ITEM\n" + 
				"             , I.ITEM_NAME\n" + 
				"             , OBI.SEQUENTIAL_NUMBER\n" + 
				"          FROM OPEN_BOX_INVENTORY OBI\n" + 
				"             , ITEM AS I\n" + 
				"         WHERE OBI.RECORD_FLAG = '1'\n" + 
				"           AND I.RECORD_FLAG = '1'\n" + 
				"           AND OBI.ID_STATUS = " + Constant.WAITING_ORDER + "\n" + 
				"           AND OBI.id_item = I.id_item\n";
		if ((itemNameSearch != null) && itemNameSearch.length() > 0) {
			sql += "           AND I.ITEM_NAME LIKE '" + itemNameSearch.trim().toUpperCase() + "%'\n";
		}
		sql += "         GROUP BY OBI.ID_ITEM\n" + 
				"                , I.ITEM_NAME\n" + 
				"                , OBI.SEQUENTIAL_NUMBER) AS OBIQ\n" + 
				" GROUP BY ID_ITEM\n" + 
				"        , ITEM_NAME\n" + 
				" ORDER BY ITEM_NAME;\n" + 
				"";

		List<?> queryList = session.createNativeQuery(sql).getResultList();

		for (int i = 0; i < queryList.size(); i++) {
			Object[] obj = (Object[]) queryList.get(i);

			Integer idItem = (Integer) obj[0];
			String itemName = (String) obj[1];

			BigDecimal qty = new BigDecimal((BigInteger) obj[2]);

			ItemModel itemModel = new ItemModel();
			itemModel.setItemName(itemName);
			itemModel.setRecordFlag("1");

			OpenBoxModel openBoxModel = new OpenBoxModel();
			openBoxModel.setIdItem(idItem);
			openBoxModel.setQty(qty);

			openBoxView = new OpenBoxView();
			openBoxView.setIdItem(idItem);
			openBoxView.setItemName(itemName);
			openBoxView.setQty(qty);

			openBoxViewList.add(openBoxView);

		}

		session.close();

		return openBoxViewList;
	}

	/**
	 * This method is responsible for select one employee in table Employees.
	 * 
	 * @param idItem This parameter is primary key of Item.
	 * @return This return is one ItemModel object, loaded with query result to the
	 *         Item table.
	 */
	public OpenBoxModel selectItemByID(Integer idOpenBoxInventory) {

		OpenBoxModel openBox = new OpenBoxModel();

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<OpenBoxModel> query = builder.createQuery(OpenBoxModel.class);
		Root<OpenBoxModel> root = query.from(OpenBoxModel.class);
		query.select(root).where(builder.equal(root.get("idOpenBoxInventory"), idOpenBoxInventory),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<OpenBoxModel> q = session.createQuery(query);
		openBox = q.getSingleResult();

		session.close();

		return openBox;
	}

	/**
	 * This method is responsible for select all item in table Item.
	 * 
	 * results to the Item table.
	 * 
	 * @return This return is one ArrayList of ItemModel, loaded with query
	 */
	// TODO: create returns to item-inventory, item-part
	public OpenBoxModel selectOpenBoxInventory(PackingSlipModel packingSlip) {

		OpenBoxModel openBox = new OpenBoxModel();

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<OpenBoxModel> query = builder.createQuery(OpenBoxModel.class);
		Root<OpenBoxModel> root = query.from(OpenBoxModel.class);
		query.select(root).where(builder.equal(root.get("idWarehouse"), packingSlip.getIdWarehouse()),
				builder.equal(root.get("idWarehouseLocation"), packingSlip.getIdWarehouseLocation()),
				builder.equal(root.get("idItem"), packingSlip.getIdItem()),
				builder.equal(root.get("idItemPart"), packingSlip.getIdItemPart()),
				builder.equal(root.get("sequentialNumber"), packingSlip.getSequentialNumber()),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		
		Query<OpenBoxModel> q = session.createQuery(query);
		
		try {
			openBox = q.getSingleResult();
		} catch (NoResultException e) {
			openBox = new OpenBoxModel();
		}

		session.close();

		return openBox;
	}

	/**
	 * This method is responsible for select all item in table Item. and count the
	 * number of boxes opended in table open_box_inventory
	 * 
	 * @return This return is one ArrayList of ItemModel, loaded with query results
	 *         to the Item table.
	 */
	// TODO: create returns to item-inventory, item-part
	public Integer qtyBoxOpened(Integer idItem) {

		String sql = "";

		Integer qty = 0;

		Session session = sessionFactory.openSession();

		sql = "SELECT COUNT(1) AS qty\n" + "  FROM ( SELECT OBI.ID_ITEM\n" + "              , OBI.SEQUENTIAL_NUMBER\n"
				+ "           FROM CHINTALY.OPEN_BOX_INVENTORY OBI\n" + "          WHERE OBI.RECORD_FLAG = '1'\n"
				+ "            AND OBI.ID_ITEM = " + idItem + "\n" + "            AND OBI.ID_STATUS = 12\n"
				+ "          GROUP BY OBI.ID_ITEM\n" + "              , OBI.SEQUENTIAL_NUMBER ) AS OBIQ\n"
				+ " GROUP BY OBIQ.ID_ITEM;\n" + "";

		List<?> queryListQTY = session.createNativeQuery(sql).getResultList();

		Object[] objQTY = (Object[]) queryListQTY.get(0);

		qty = (Integer) objQTY[0];

		session.close();

		return qty;
	}
}
