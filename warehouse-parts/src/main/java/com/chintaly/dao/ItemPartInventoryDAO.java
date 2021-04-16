package com.chintaly.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.chintaly.model.ItemPartInventoryModel;
import com.chintaly.model.ItemPartModel;
import com.chintaly.model.PackingSlipModel;
import com.chintaly.view.ItemPartInventoryView;

public class ItemPartInventoryDAO {

	static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

	/**
	 * This is the instance of ItemDAO.
	 */
	private static ItemPartInventoryDAO instance;

	public static ItemPartInventoryDAO getInstance() {

		if (instance == null) {
			instance = new ItemPartInventoryDAO();
		}
		return instance;
	}

	/**
	 * This Method is responsible for insert new Item in table Item.
	 * 
	 * @param item ItemModel object.
	 */
	public void insertItemPartInventory(ItemPartInventoryModel itemPartInv) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(itemPartInv);
		session.flush();

		transaction.commit();
		session.close();
	}

	/**
	 * This Method is responsible for insert new Item in table Item.
	 * 
	 * @param item ItemModel object.
	 */
	public void updateItemPartInventory(ItemPartInventoryModel itemPartInv) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.update(itemPartInv);
		session.flush();

		transaction.commit();
		session.close();
	}

	/**
	 * This Method is responsible for insert new Item in table Item.
	 * 
	 * @param item ItemModel object.
	 */
	public void updateItemPartInventoryQty(ItemPartInventoryModel itemPartInv) {
		/*
		 * Session session = sessionFactory.openSession();
		 * 
		 * String sql;
		 * 
		 * SQLQuery query;
		 * 
		 * sql = "		UPDATE ITEM_PART_INVENTORY SET QTY = QTY - PQTY \n" +
		 * "		WHERE ID_ITEM = PITEM\n" +
		 * "		AND ID_ITEM_PART = PID_ITEM_PART\n" +
		 * "		AND SEQUENTIAL_NUMBER = PSEQUENTIAL_NUMBER\n" +
		 * "		AND ID_WAREHOUSE = PID_WAREHOUSE\n" +
		 * "		AND ID_WAREHOUSE_LOCATION = PID_WAREHOUSE_LOCATION\n" +
		 * "		AND RECORD_FLAG = \"1\"\n" + "";
		 * 
		 * query = session.createSQLQuery(sql);
		 * 
		 * List<?> queryList = query.list();
		 * 
		 * session.close();
		 */
	}

	/**
	 * This method is responsible for select one employee in table Employees.
	 * 
	 * @param idItem This parameter is primary key of Item.
	 * @return This return is one ItemModel object, loaded with query result to the
	 *         Item table.
	 */
	public ItemPartInventoryModel selectItemByID(Integer idItemPartInventory) {

		ItemPartInventoryModel itemPart = new ItemPartInventoryModel();

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ItemPartInventoryModel> query = builder.createQuery(ItemPartInventoryModel.class);
		Root<ItemPartInventoryModel> root = query.from(ItemPartInventoryModel.class);
		query.select(root).where(builder.equal(root.get("idItemPartInventory"), idItemPartInventory),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));

		Query<ItemPartInventoryModel> q = session.createQuery(query);
		itemPart = q.getSingleResult();

		session.close();

		return itemPart;
	}

	/**
	 * This method is responsible for select all item in table Item.
	 * 
	 * @return This return is one ArrayList of ItemModel, loaded with query results
	 *         to the Item table.
	 */
	// TODO: create returns to item-inventory, item-part
	public ArrayList<ItemPartInventoryView> selectAllItemPartInventory(String itemPartSearch) {

		ArrayList<ItemPartInventoryView> itemPartInventoryViewList = new ArrayList<ItemPartInventoryView>();
		ItemPartInventoryView itemPartInventoryView;

		String sql;

		Session session = sessionFactory.openSession();

		sql = " SELECT I.ID_ITEM, I.BAR_CODE, I.ITEM_NAME, I.DESCRIPTION, I.COLOR, I.PER_BOX, I.DATE_REGISTER,"
				+ " II.ID_ITEM_PART_INVENTORY, II.ID_WAREHOUSE, II.ID_WAREHOUSE_LOCATION, II.QTY, II.DATE_CHECKIN, II.DATE_CHECKOUT, II.NOTES,"
				+ " IP.ID_ITEM_PART, IP.ITEM_PART_NAME, II.SEQUENTIAL_NUMBER" 
				+ " FROM CHINTALY.ITEM AS I,"
				+ " CHINTALY.ITEM_PART AS IP," 
				+ " CHINTALY.ITEM_PART_INVENTORY AS II" 
				+ " WHERE I.RECORD_FLAG = '1'"
				+ " AND IP.RECORD_FLAG = '1'" 
				+ " AND II.RECORD_FLAG = '1'" 
				+ " AND IP.ID_ITEM_PART = II.ID_ITEM_PART"
				+ " AND II.ID_ITEM = I.ID_ITEM";

		if (itemPartSearch != null) {
			sql = sql + "   AND I.ITEM_NAME LIKE '" + itemPartSearch + "%'";
		}

		sql += " ORDER BY I.ITEM_NAME ASC, II.SEQUENTIAL_NUMBER ASC, IP.ITEM_PART_NAME, II.DATE_CHECKOUT DESC;";

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

			Integer idItemPartInventory = (Integer) obj[7];
			Integer idWarehouse = (Integer) obj[8];
			Integer idWarehouseLocation = (Integer) obj[9];
			BigDecimal qty = (BigDecimal) obj[10];
			Date dateLastIn = (Date) obj[11];
			Date dateLastOut = (Date) obj[12];
			String notes = (String) obj[13];

			Integer idItemPart = (Integer) obj[14];
			String itemPartName = (String) obj[15];
			String sequentialNumber = (String) obj[16];

			ItemModel itemModel = new ItemModel();
			itemModel.setBarCode(barCode);
			itemModel.setColor(color);
			itemModel.setDateRegister(dateRegister);
			itemModel.setDescription(description);
			itemModel.setIdItem(idItemPart);
			itemModel.setItemName(itemName);
			itemModel.setPerBox(perBox);
			itemModel.setRecordFlag("1");

			ItemPartInventoryModel itemPartInventoryModel = new ItemPartInventoryModel();
			itemPartInventoryModel.setDate_last_in(dateLastIn);
			itemPartInventoryModel.setDate_last_out(dateLastOut);
			itemPartInventoryModel.setIdItem(idItem);
			itemPartInventoryModel.setIdItemPartInventory(idItemPartInventory);
			itemPartInventoryModel.setIdItemPart(idItemPart);
			itemPartInventoryModel.setIdWarehouse(idWarehouse);
			itemPartInventoryModel.setIdWarehouseLocation(idWarehouseLocation);

			if (notes.length() > 50) {
				itemPartInventoryModel.setNotes(notes.substring(1, 50));
			} else {
				itemPartInventoryModel.setNotes(notes);
			}

			itemPartInventoryModel.setQty(qty);
			itemPartInventoryModel.setSequentialNumber(sequentialNumber);
			itemPartInventoryModel.setRecordFlag("1");

			ItemPartModel itemPartModel = new ItemPartModel();
			itemPartModel.setItemPartName(itemPartName);
			itemPartModel.setIdItemPart(idItemPart);

			itemPartInventoryView = new ItemPartInventoryView();
			itemPartInventoryView.setBarCode(barCode);
			itemPartInventoryView.setColor(color);
			itemPartInventoryView.setDateLastIn(dateLastIn);
			itemPartInventoryView.setDateLastOut(dateLastOut);
			itemPartInventoryView.setDateRegister(dateRegister);
			itemPartInventoryView.setDescription(description);
			itemPartInventoryView.setIdItem(idItem);
			itemPartInventoryView.setItemName(itemName);
			itemPartInventoryView.setIdItemPartInventory(idItemPartInventory);
			itemPartInventoryView.setIdItemPart(idItemPart);
			itemPartInventoryView.setIdWarehouse(idWarehouse);
			itemPartInventoryView.setItemPartName(itemPartName);
			itemPartInventoryView.setPerBox(perBox);
			itemPartInventoryView.setQty(qty);
			itemPartInventoryView.setSequentialNumber(sequentialNumber);
			// itemPartInventoryView.setNotes(notes);
			if (notes.length() > 50) {
				itemPartInventoryView.setNotes(notes.substring(1, 50));
			} else {
				itemPartInventoryView.setNotes(notes);
			}

			itemPartInventoryViewList.add(itemPartInventoryView);

		}

		session.close();

		return itemPartInventoryViewList;
	}

	/**
	 * This method is responsible for select all item in table Item.
	 * 
	 * results to the Item table.
	 * 
	 * @return This return is one ArrayList of ItemModel, loaded with query
	 */
	// TODO: create returns to item-inventory, item-part
	public ItemPartInventoryModel selectItemPartInventory(PackingSlipModel packingSlip) {

		ItemPartInventoryModel itemPart = new ItemPartInventoryModel();

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ItemPartInventoryModel> query = builder.createQuery(ItemPartInventoryModel.class);
		Root<ItemPartInventoryModel> root = query.from(ItemPartInventoryModel.class);

		query.select(root).where(builder.equal(root.get("idWarehouse"), packingSlip.getIdWarehouse()),
				builder.equal(root.get("idWarehouseLocation"), packingSlip.getIdWarehouseLocation()),
				builder.equal(root.get("idItem"), packingSlip.getIdItem()),
				builder.equal(root.get("idItemPart"), packingSlip.getIdItemPart()),
				builder.equal(root.get("sequentialNumber"), packingSlip.getSequentialNumber()),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));

		Query<ItemPartInventoryModel> queryItemPart = session.createQuery(query);
		try {
			itemPart = queryItemPart.getSingleResult();
		} catch (NoResultException e) {
			itemPart = null;
		}

		session.close();

		return itemPart;
	}

}
