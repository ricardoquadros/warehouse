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
import com.chintaly.model.PackingSlipModel;
import com.chintaly.model.StatusModel;
import com.chintaly.model.UserPackingSlipModel;
import com.chintaly.view.PackingSlipView;

public class PackingSlipDAO {

	static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

	private static PackingSlipDAO instance;

	public static PackingSlipDAO getInstance() {

		if (instance == null) {
			instance = new PackingSlipDAO();
		}
		return instance;
	}

	public void insertPackingSlip(PackingSlipModel packingSlip) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(packingSlip);

		transaction.commit();
		session.close();
	}

	// TODO: create returns to item-inventory, item-part
	public ArrayList<PackingSlipView> selectPackingSlip(String searchItem) {

		ArrayList<PackingSlipView> packingSlipListView = new ArrayList<PackingSlipView>();
		PackingSlipView packingSlipView;

		Session session = sessionFactory.openSession();

		String sql = "SELECT PH.ID_PACKINGSLIP_HISTORY,\n" 
				+ "       PH.ID_WAREHOUSE_LOCATION,\n" 
				+ "       PH.ID_WAREHOUSE,\n"
				+ "       CAST(1 AS UNSIGNED) AS ID_IMAGE,\n" 
				+ "       PH.ID_ITEM,\n" 
				+ "       PH.ID_ITEM_PART,\n"
				+ "       PH.ID_STATUS,\n" 
				+ "       PH.QTY_STOCK,\n" 
				+ "       PH.QTY,\n" 
				+ "       PH.DATE_CHECKIN,\n"
				+ "       PH.DATE_CHECKOUT,\n" 
				+ "       PH.PART_TAKEN,\n" 
				+ "       PH.PACKINGSLIP,\n"
				+ "       PH.APPROVED_BY,\n" 
				+ "       PH.NOTES,\n" 
				+ "       PH.BILL_SHIP,\n"
				+ "       PH.PO_NUMBER,\n" 
				+ "       PH.PO_NUMBER_INVOICE,\n" 
				+ "       I.ITEM_NAME,\n"
				+ "       IP.ITEM_PART_NAME,\n" 
				+ "       PH.SEQUENTIAL_NUMBER,\n"
				+ "       PH.ID_USER_PACKINGSLIP,\n"
				+ "       PH.DIMENSION,\n"
				+ "       PH.WEIGHT,\n"
				+ "       PH.FREIGHT,\n"
				+ "       PH.EMAIL_SENT_COUNT\n"
				+ "  FROM PACKINGSLIP_HISTORY AS PH,\n" 
				+ "       ITEM AS I,\n" 
				+ "       ITEM_PART AS IP\n"
				+ " WHERE PH.RECORD_FLAG = \"1\"\n" 
				+ "       AND I.RECORD_FLAG = \"1\"\n"
				+ "       AND IP.RECORD_FLAG = \"1\"\n" 
				+ "       AND I.ID_ITEM = PH.ID_ITEM\n"
				+ "       AND IP.ID_ITEM_PART = PH.ID_ITEM_PART\n";
		if (searchItem != null) {
			sql += " AND I.ITEM_NAME LIKE '" + searchItem.trim().toUpperCase() + "%'\n";
		}
		sql += " ORDER BY I.ITEM_NAME ASC, PH.PACKINGSLIP ASC, PH.SEQUENTIAL_NUMBER ASC, IP.ITEM_PART_NAME ASC, PH.PACKINGSLIP ASC, PH.DATE_CHECKOUT DESC";

		sql += " LIMIT " + Constant.LIMIT_RECORD + ";";

		List<?> queryList = session.createNativeQuery(sql).getResultList();

		for (int i = 0; i < queryList.size(); i++) {
			Object[] obj = (Object[]) queryList.get(i);

			Integer idPartHistory = (Integer) obj[0];
			Integer idWarehouseLocation = (Integer) obj[1];
			Integer idWarehouse = (Integer) obj[2];
			Integer idImage = (Integer) 1; // obj[3];
			Integer idItem = (Integer) obj[4];
			Integer idItemPart = (Integer) obj[5];
			Integer idStatus = (Integer) obj[6];
			BigDecimal qtyStock = (BigDecimal) obj[7];
			BigDecimal qty = (BigDecimal) obj[8];
			Date dateCheckIN = (Date) obj[9];
			Date dateCheckOUT = (Date) obj[10];
			String partTaken = (String) obj[11];
			String packingSlipNumber = (String) obj[12];
			String approvedBy = (String) obj[13];
			String notes = (String) obj[14];
			String billShip = (String) obj[15];
			String poNumber = (String) obj[16];
			String poNumberInvoice = (String) obj[17];
			String itemName = (String) obj[18];
			String itemPartName = (String) obj[19];
			String sequentialNumber = (String) obj[20];

			Integer idUserPackingslip = 1; //(Integer) obj[21];
			String dimension = (String) obj[22];
			String weight = (String) obj[23];
			String freight = (String) obj[24];
			Integer emailSentCount = (Integer) obj[25];

			StatusModel status = StatusDAO.getInstance().selectStatusById(idStatus);
			UserPackingSlipModel userPackingSlip = UserPackingSlipDAO.getInstance().selectPackingSlipById(idUserPackingslip);

			packingSlipView = new PackingSlipView();
			packingSlipView.setIdPartHistory(idPartHistory);
			packingSlipView.setIdWarehouseLocation(idWarehouseLocation);
			packingSlipView.setIdWarehouse(idWarehouse);
			packingSlipView.setIdImage(idImage);
			packingSlipView.setIdItem(idItem);
			packingSlipView.setIdItemPart(idItemPart);
			packingSlipView.setIdStatus(idStatus);
			packingSlipView.setQtyStock(qtyStock);
			packingSlipView.setQty(qty);
			packingSlipView.setDate(new Date());
			packingSlipView.setDateCheckIN(dateCheckIN);
			packingSlipView.setDateCheckOUT(dateCheckOUT);
			packingSlipView.setPartTaken(partTaken);
			packingSlipView.setPackingSlip(packingSlipNumber);
			packingSlipView.setApprovedBy(approvedBy);
			packingSlipView.setNotes(notes);
			packingSlipView.setPoNumber(poNumber);
			packingSlipView.setPoNumberInvoice(poNumberInvoice);
			packingSlipView.setItemName(itemName);
			packingSlipView.setStatus(status.getStatus());
			packingSlipView.setItemPartName(itemPartName);
			packingSlipView.setSequentialNumber(sequentialNumber);
			if(billShip.length() > 40) {
				packingSlipView.setBillShip(billShip.substring(0, 39));
			} else {
				packingSlipView.setBillShip(billShip);
			}
			packingSlipView.setUserPackingSlip(userPackingSlip.getUserName());
			packingSlipView.setDimension(dimension);
			packingSlipView.setWeight(weight);
			packingSlipView.setFreight(freight);
			packingSlipView.setEmailSentCount(emailSentCount);

			packingSlipListView.add(packingSlipView);

		}

		session.close();

		return packingSlipListView;
	}

	public PackingSlipModel selectPackingSlipById(Integer idPackingSlip) {

		PackingSlipModel packingSlip = new PackingSlipModel();

		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<PackingSlipModel> query = builder.createQuery(PackingSlipModel.class);
		Root<PackingSlipModel> root = query.from(PackingSlipModel.class);
		query.select(root).where(builder.equal(root.get("idPartHistory"), idPackingSlip),
				builder.equal(root.get("recordFlag"), Constant.RECORD_FLAG_ON));
		Query<PackingSlipModel> q = session.createQuery(query);
		packingSlip = q.getSingleResult();
		
		session.close();

		return packingSlip;
	}

	public void loadPackingSlipByNumber() {

	}
}
