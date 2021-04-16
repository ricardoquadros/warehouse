package com.chintaly.bo;

import com.chintaly.main.Constant;
import com.chintaly.model.PackingSlipModel;
import com.chintaly.view.PackingSlipView;

public class PackingSlipBO {

	public PackingSlipModel prepareToSavePackingSlip(PackingSlipView packingSlipView) {

		//Integer idStatus = StatusDAO.getInstance().selectStatusByName(Constant.STATUS_STANDBY);

		PackingSlipModel packingSlip = new PackingSlipModel();

		packingSlip.setIdWarehouse(Constant.WAREHOUSE_ID);
		packingSlip.setIdWarehouseLocation(Constant.WAREHOUSE_LOCATION_ID);
		//packingSlip.setIdStatus(idStatus);
		//packingSlip.setIdImage(Constant.IMAGE_ID);
		packingSlip.setIdItem(packingSlipView.getIdItem());
		packingSlip.setIdItemPart(packingSlipView.getIdItemPart());
		packingSlip.setDateCheckIn(packingSlipView.getDateCheckIN());
		packingSlip.setDateCheckOut(packingSlipView.getDateCheckOUT());
		packingSlip.setApprovedBy(packingSlipView.getApprovedBy());
		packingSlip.setBillShip(packingSlipView.getBillShip());
		packingSlip.setNotes(packingSlipView.getNotes());
		packingSlip.setPackingSlip(packingSlipView.getPackingSlip());
		packingSlip.setPartTaken(packingSlipView.getPartTaken());
		packingSlip.setPoNumber(packingSlipView.getPoNumber());
		packingSlip.setPoNumberInvoice(packingSlipView.getPoNumberInvoice());
		packingSlip.setQtyMove(packingSlipView.getQty());
		packingSlip.setQtyStockBefore(packingSlipView.getQtyStock());
		packingSlip.setRecordFlag("1");

		return packingSlip;
	}

	//public Integer selectIdItemPartInventory() {
		
	//}
}
