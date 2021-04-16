package com.chintaly.dao;

import java.util.ArrayList;
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
import com.chintaly.model.ImageHistoryModel;

public class ImageHistoryDAO {

	static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

	private static ImageHistoryDAO instance;

	public static ImageHistoryDAO getInstance() {

		if (instance == null) {
			instance = new ImageHistoryDAO();
		}
		return instance;
	}

	public void insertImage(ImageHistoryModel image) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(image);

		transaction.commit();
		session.close();
	}

	public void deleteImage(Integer idImage) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		ImageHistoryModel image = (ImageHistoryModel) session.get(ImageHistoryModel.class, idImage);

		session.delete(image);

		transaction.commit();
		session.close();
	}

	public void updateImage(ImageHistoryModel image) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.update(image);

		transaction.commit();
		session.close();
	}

	public ArrayList<ImageHistoryModel> selectImagePackingSlip(String packingSlipNumber) {

		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<ImageHistoryModel> query = builder.createQuery(ImageHistoryModel.class);
		Root<ImageHistoryModel> root = query.from(ImageHistoryModel.class);

		query.select(root).where(builder.equal(root.get("packingslipNumber"), packingSlipNumber),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));

		Query<ImageHistoryModel> q = session.createQuery(query);

		ArrayList<ImageHistoryModel> imageHistory = (ArrayList<ImageHistoryModel>) q.getResultList();

		session.close();

		return imageHistory;
	}
	
	public List<String> selectImageListPackingSlip(String packingSlipNumber) {
		
		ArrayList<ImageHistoryModel> imageHistory = selectImagePackingSlip(packingSlipNumber);
		
		List<String> imagesList = new ArrayList<String>();
		
		for (int i = 0; i < imageHistory.size(); i++) {
			imagesList.add(imageHistory.get(i).getImagePathFolder() + imageHistory.get(i).getImageName());
		}
		
		return imagesList;
	}
	
	

}
