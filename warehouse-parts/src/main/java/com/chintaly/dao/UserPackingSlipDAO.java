package com.chintaly.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.chintaly.factory.SessionFactoryProvider;
import com.chintaly.main.Constant;
import com.chintaly.model.UserPackingSlipModel;

public class UserPackingSlipDAO {


	static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

	private static UserPackingSlipDAO instance;

	public static UserPackingSlipDAO getInstance() {

		if (instance == null) {
			instance = new UserPackingSlipDAO();
		}
		return instance;
	}

	public void insertUserPackingSlip(UserPackingSlipModel userPackingSlip) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(userPackingSlip);

		transaction.commit();
		session.close();
	}

	// TODO: create returns to item-inventory, item-part
	public UserPackingSlipModel selectUserPackingSlipByName(String searchName) {

		UserPackingSlipModel userPackingSlip = new UserPackingSlipModel();

		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserPackingSlipModel> query = builder.createQuery(UserPackingSlipModel.class);
		Root<UserPackingSlipModel> root = query.from(UserPackingSlipModel.class);
		query.select(root).where(builder.equal(root.get("userName"), searchName),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<UserPackingSlipModel> q = session.createQuery(query);
		userPackingSlip = q.getSingleResult();
		
		session.close();

		return userPackingSlip;
	}

	public UserPackingSlipModel selectPackingSlipById(Integer idUser) {

		UserPackingSlipModel userPackingSlip = new UserPackingSlipModel();

		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserPackingSlipModel> query = builder.createQuery(UserPackingSlipModel.class);
		Root<UserPackingSlipModel> root = query.from(UserPackingSlipModel.class);
		query.select(root).where(builder.equal(root.get("idUserPackingSlip"), idUser),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<UserPackingSlipModel> q = session.createQuery(query);
		userPackingSlip = q.getSingleResult();
		
		session.close();

		return userPackingSlip;
	}

	public void loadPackingSlipByNumber() {

	}
}
