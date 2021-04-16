package com.chintaly.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chintaly.factory.SessionFactoryProvider;
import com.chintaly.main.Constant;
import com.chintaly.model.WarehouseLocationModel;

public class WarehouseLocationDAO {

	static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

	/**
	 * This is the instance of WarehouseLocationDAO.
	 */
	private static WarehouseLocationDAO instance;

	public static WarehouseLocationDAO getInstance() {

		if (instance == null) {
			instance = new WarehouseLocationDAO();
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
	public WarehouseLocationModel selectWarehouseLocationById(Integer idWL) {

		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<WarehouseLocationModel> query = builder.createQuery(WarehouseLocationModel.class);
		Root<WarehouseLocationModel> root = query.from(WarehouseLocationModel.class);
		query.select(root).where(builder.equal(root.get("idWarehouseLocation"), idWL),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<WarehouseLocationModel> q = session.createQuery(query);
		WarehouseLocationModel wl = q.getSingleResult();

		session.close();

		return wl;
	}

	public Integer idWarehouseLocationByName(String name) {
		
		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<WarehouseLocationModel> query = builder.createQuery(WarehouseLocationModel.class);
		Root<WarehouseLocationModel> root = query.from(WarehouseLocationModel.class);
		query.select(root).where(builder.equal(root.get("description"), name),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<WarehouseLocationModel> q = session.createQuery(query);
		WarehouseLocationModel wl = q.getSingleResult();

		session.close();

		return wl.getIdWarehouse();
	}
}
