package com.chintaly.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.chintaly.factory.SessionFactoryProvider;
import com.chintaly.main.Constant;
import com.chintaly.model.ItemInventoryModel;
import com.chintaly.model.ItemModel;
import com.chintaly.model.ItemPartModel;
import com.chintaly.view.ItemInventoryView;

/**
 * This Class is responsible for provide access to data(Data Access Object).
 * 
 * @author Ricardo Quadros.
 * @version 1.0
 * @since 09/01/2018
 */
// TODO: Create errors exceptions
// TODO: include Image & Item Inventory
public class ItemDAO {

	static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

	/**
	 * This is the instance of ItemDAO.
	 */
	private static ItemDAO instance;

	public static ItemDAO getInstance() {

		if (instance == null) {
			instance = new ItemDAO();
		}
		return instance;
	}

	/**
	 * This Method is responsible for insert new Item in table Item.
	 * 
	 * @param item
	 *            ItemModel object.
	 */
	public void insertItem(ItemModel item) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(item);

		transaction.commit();
		session.close();
	}

	/**
	 * This Method is responsible for delete one Employee in table Employees.
	 * 
	 * @param idItem
	 *            This parameter is primary key of Item.
	 */
	public void deleteItem(long idItem) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		ItemModel item = (ItemModel) session.get(ItemModel.class, idItem);

		session.delete(item);

		transaction.commit();
		session.close();
	}

	/**
	 * This method is responsible for Update one Employee in table Employees.
	 * 
	 * @param itemModel
	 *            ItemModel object.
	 */
	public void updateItem(ItemModel item) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.update(item);

		transaction.commit();
		session.close();
	}

	/**
	 * This method is responsible for select all item in table Item.
	 * 
	 * @return This return is one ArrayList of ItemModel, loaded with query results
	 *         to the Item table.
	 */
	// TODO: create returns to item-inventory, item-part
	public ArrayList<ItemInventoryView> selectAllItem2(String itemNameSearch) {

		ArrayList<ItemInventoryView> itemInventoryViewList = new ArrayList<ItemInventoryView>();
		ItemInventoryView itemInventoryView;

		String sql;

		Session session = sessionFactory.openSession();

		sql = " SELECT I.ID_ITEM, I.BAR_CODE, I.ITEM_NAME, I.DESCRIPTION, I.COLOR, I.PER_BOX, I.DATE_REGISTER, \n"
				+ "  FROM CHINTALY.ITEM AS I,\n"
				+ " WHERE I.RECORD_FLAG = '1'\n";

		if (itemNameSearch != null) {
			sql = sql + "   AND I.ITEM_NAME LIKE '" + itemNameSearch.trim().toUpperCase() + "%'";
		}

		sql += ";";

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

			Integer idItemInventory = 0;
			Integer idWarehouse = (Integer) obj[7];
			Integer idWarehouseLocation = (Integer) obj[8];
			BigDecimal qty = (BigDecimal) obj[9];
			Date dateLastIn = (Date) obj[10];
			Date dateLastOut = (Date) obj[11];
			String notes = (String) obj[12];

			Integer idItemPart = (Integer) obj[13];
			String itemPartName = (String) obj[14];

			ItemModel itemModel = new ItemModel();
			itemModel.setBarCode(barCode);
			itemModel.setColor(color);
			itemModel.setDateRegister(dateRegister);
			itemModel.setDescription(description);
			itemModel.setIdItem(idItemPart);
			itemModel.setItemName(itemName);
			itemModel.setPerBox(perBox);
			itemModel.setRecordFlag("1");

			ItemInventoryModel itemInventoryModel = new ItemInventoryModel();
			itemInventoryModel.setDate_last_in(dateLastIn);
			itemInventoryModel.setDate_last_out(dateLastOut);
			itemInventoryModel.setIdItem(idItem);
			itemInventoryModel.setIdItemInventory(idItemInventory);
			itemInventoryModel.setIdItemPart(idItemPart);
			itemInventoryModel.setIdWarehouse(idWarehouse);
			itemInventoryModel.setIdWarehouseLocation(idWarehouseLocation);
			itemInventoryModel.setNotes(notes);
			itemInventoryModel.setQty(qty);
			itemInventoryModel.setRecordFlag("1");

			ItemPartModel itemPartModel = new ItemPartModel();
			itemPartModel.setItemPartName(itemPartName);
			itemPartModel.setIdItemPart(idItemPart);

			itemInventoryView = new ItemInventoryView();
			itemInventoryView.setBarCode(barCode);
			itemInventoryView.setColor(color);
			itemInventoryView.setDateLastIn(dateLastIn);
			itemInventoryView.setDateLastOut(dateLastOut);
			itemInventoryView.setDateRegister(dateRegister);
			itemInventoryView.setDescription(description);
			itemInventoryView.setIdItem(idItem);
			itemInventoryView.setItemName(itemName);
			itemInventoryView.setIdItemInventory(idItemInventory);
			itemInventoryView.setIdItemPart(idItemPart);
			itemInventoryView.setIdWarehouse(idWarehouse);
			itemInventoryView.setItemPartName(itemPartName);
			itemInventoryView.setPerBox(perBox);
			itemInventoryView.setQty(qty);

			itemInventoryViewList.add(itemInventoryView);

		}

		session.close();

		return itemInventoryViewList;
	}

	/**
	 * This method is responsible for select all item in table Item.
	 * 
	 * @return This return is one ArrayList of ItemModel, loaded with query results
	 *         to the Item table.
	 */
	// TODO: CRITERIA TO FIELD RECORD-FLAG = "1", 0 MEANS RECORD DELETED.

	public ArrayList<ItemModel> selectAllItem(String itemSearch) {

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ItemModel> query = builder.createQuery(ItemModel.class);
		Root<ItemModel> root = query.from(ItemModel.class);
		query.select(root).where(builder.like(root.get("itemName"), itemSearch + "%"));
		Query<ItemModel> q = session.createQuery(query);
		ArrayList<ItemModel> itemList = (ArrayList<ItemModel>) q.getResultList();

		session.close();

		return itemList;
	}

	/**
	 * This method is responsible for select all item in table Item using DataTable
	 * Lazy(PrimesFaces).
	 * 
	 * @return This return is one ArrayList of ItemModel, loaded with query results
	 *         to the Item table using lazyload.
	 */
	// TODO: CRITERIA TO FIELD RECORD-FLAG = "1", 0 MEANS RECORD DELETED.
/*	public ArrayList<ItemModel> selectAllItemByPage(int primeiroDigito, int segundoDigito) {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ItemModel.class);
		criteria.setFirstResult(primeiroDigito);
		criteria.setMaxResults(segundoDigito);
		@SuppressWarnings("unchecked")
		ArrayList<ItemModel> itemList = (ArrayList<ItemModel>) criteria.list();
		session.close();
		return (ArrayList<ItemModel>) itemList;
	}
*/
	/**
	 * This method is responsible for select one employee in table Employees.
	 * 
	 * @param idItem
	 *            This parameter is primary key of Item.
	 * @return This return is one ItemModel object, loaded with query result to the
	 *         Item table.
	 */
	public ItemModel selectItemByID(long idItem) {

		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ItemModel> query = builder.createQuery(ItemModel.class);
		Root<ItemModel> root = query.from(ItemModel.class);
		query.select(root).where(builder.equal(root.get("idItem"), idItem),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<ItemModel> q = session.createQuery(query);
		ItemModel item = q.getSingleResult();

		session.close();

		return item;
	}

	/**
	 * This method is responsible for select one employee in table Employees.
	 * 
	 * @param Item Name
	 *            This parameter is primary key of Item.
	 * @return This return is one Item id, loaded with query result of the table
	 */
	public Integer selectItemByName(String itemName) {

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ItemModel> query = builder.createQuery(ItemModel.class);
		Root<ItemModel> root = query.from(ItemModel.class);
		query.select(root).where(builder.equal(root.get("itemName"), itemName),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<ItemModel> q = session.createQuery(query);
		ItemModel item = q.getSingleResult();

		session.close();

		return item.getIdItem();
	}

}
