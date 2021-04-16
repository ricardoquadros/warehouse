package com.chintaly.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chintaly.factory.SessionFactoryProvider;
import com.chintaly.main.Constant;
import com.chintaly.model.ItemInventoryModel;

public class ItemInventoryDAO {

	static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

	/**
	 * This is the instance of ItemDAO.
	 */
	private static ItemInventoryDAO instance;

	public static ItemInventoryDAO getInstance() {

		if (instance == null) {
			instance = new ItemInventoryDAO();
		}
		return instance;
	}

	/**
	 * This method is responsible for select one employee in table Employees.
	 * 
	 * @param idItem
	 *            This parameter is primary key of Item.
	 * @return This return is one ItemModel object, loaded with query result to the
	 *         Item table.
	 */
	public ItemInventoryModel selectItemByID(Integer idItemInventory) {

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ItemInventoryModel> query = builder.createQuery(ItemInventoryModel.class);
		Root<ItemInventoryModel> root = query.from(ItemInventoryModel.class);
		query.select(root).where(builder.equal(root.get("idItemInventory"), idItemInventory),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<ItemInventoryModel> q = session.createQuery(query);

		ItemInventoryModel item = q.getSingleResult();
		
		session.close();

		return item;
	}


}
