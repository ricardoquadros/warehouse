package com.chintaly.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chintaly.factory.SessionFactoryProvider;
import com.chintaly.main.Constant;
import com.chintaly.model.StatusModel;

public class StatusDAO {

	static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

	/**
	 * This is the instance of StatusDAO.
	 */
	private static StatusDAO instance;

	public static StatusDAO getInstance() {

		if (instance == null) {
			instance = new StatusDAO();
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
	public StatusModel selectStatusById(Integer idStatus) {

		StatusModel status = new StatusModel();
		
		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<StatusModel> query = builder.createQuery(StatusModel.class);
		Root<StatusModel> root = query.from(StatusModel.class);
		query.select(root).where(builder.equal(root.get("idStatus"), idStatus),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<StatusModel> q = session.createQuery(query);
		status = q.getSingleResult();
		
		session.close();

		return status;
	}

	public StatusModel selectStatusByName(String statusName) {

		Session session = sessionFactory.openSession();

		StatusModel status = new StatusModel();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<StatusModel> query = builder.createQuery(StatusModel.class);
		Root<StatusModel> root = query.from(StatusModel.class);
		query.select(root).where(builder.equal(root.get("status"), statusName),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<StatusModel> q = session.createQuery(query);
		status = q.getSingleResult();
		
		session.close();

		return status;
	}
}
