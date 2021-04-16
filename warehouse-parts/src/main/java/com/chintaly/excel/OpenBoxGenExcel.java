package com.chintaly.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.chintaly.main.Constant;
import com.chintaly.view.OpenBoxView;

public class OpenBoxGenExcel {

	String datePattern = "yyyy-MM-dd";
	SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);

	public void genOpenBoxSynthetic(ArrayList<OpenBoxView> openBoxViewList) throws IOException {

		String excelFileName = Constant.OPENBOX_REPORT_SYNTHTTIC;

		String sheetName = "Synthetic";// name of sheet

		Integer xlsHeader = 0;

		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName);

		// iterating r number of rows
		for (int i = 0; i < openBoxViewList.size(); i++) {

			if (xlsHeader == 0) {
				XSSFRow row = sheet.createRow(i);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("Item Name");
				row.createCell(2).setCellValue("QTY");
				xlsHeader = 1;
			}

			XSSFRow row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(openBoxViewList.get(i).getIdItem());
			row.createCell(1).setCellValue(openBoxViewList.get(i).getItemName());
			row.createCell(2).setCellValue(Integer.valueOf(openBoxViewList.get(i).getQty().intValue()));
		}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

	public void genOpenBoxAnalyticParts(ArrayList<OpenBoxView> openBoxViewList) throws IOException {

		String excelFileName = Constant.OPENBOX_REPORT_ANALYTIC_PARTS;

		String sheetName = "AnalyticParts";// name of sheet

		Integer xlsHeader = 0;

		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName);

		// iterating r number of rows
		for (int i = 0; i < openBoxViewList.size(); i++) {

			if (xlsHeader == 0) {
				XSSFRow row = sheet.createRow(i);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("Item Name");
				row.createCell(2).setCellValue("Part");
				row.createCell(3).setCellValue("QTY");
				xlsHeader = 1;
			}

			XSSFRow row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(openBoxViewList.get(i).getIdItem());
			row.createCell(1).setCellValue(openBoxViewList.get(i).getItemName());
			row.createCell(2).setCellValue(openBoxViewList.get(i).getItemPartName());
			row.createCell(3).setCellValue(Integer.valueOf(openBoxViewList.get(i).getQty().intValue()));

		}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();

	}

	public void genOpenBoxAnalytic(ArrayList<OpenBoxView> openBoxViewList) throws IOException {

		String excelFileName = Constant.OPENBOX_REPORT_ANALYTIC;

		String sheetName = "Analytic";// name of sheet

		Integer xlsHeader = 0;

		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName);
		XSSFRow row = null;

		Integer idItemAux = 0;
		int numColumn = 0;
		int colAux1 = 5;
		int colAux2 = 6;
		int colAux3 = 7;

		String sequentialAux = "";
		String dateString = "";

		int i = 0;
		int lineNum = 0;
		while (i < (openBoxViewList.size() - 1)) {

			if (xlsHeader == 0) {
				row = sheet.createRow(++lineNum);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("Sequential");
				row.createCell(2).setCellValue("Item");
				row.createCell(3).setCellValue("Status");
				row.createCell(4).setCellValue("QTY");
				row.createCell(5).setCellValue("Part Used");
				row.createCell(6).setCellValue("Packing Slip");
				row.createCell(7).setCellValue("Last Update");
				xlsHeader = 1;
			}

			dateString = dateFormat.format(openBoxViewList.get(i).getDateCheckOut());

			idItemAux = openBoxViewList.get(i).getIdItem();
			sequentialAux = openBoxViewList.get(i).getSequentialNumber();

			if (numColumn == 0) {

				row = sheet.createRow(++lineNum);
				row.createCell(0).setCellValue(openBoxViewList.get(i).getIdItem());
				row.createCell(1).setCellValue(openBoxViewList.get(i).getSequentialNumber());
				row.createCell(2).setCellValue(openBoxViewList.get(i).getItemName());
				row.createCell(3).setCellValue(openBoxViewList.get(i).getDescStatus());
				row.createCell(4).setCellValue(Integer.valueOf(openBoxViewList.get(i).getQty().intValue()));
			}

			while ((idItemAux.intValue() == openBoxViewList.get(i).getIdItem().intValue())
					&& (sequentialAux.equals(openBoxViewList.get(i).getSequentialNumber()))) {

				row.createCell(colAux1 + numColumn).setCellValue(openBoxViewList.get(i).getItemPartName());
				row.createCell(colAux2 + numColumn).setCellValue(openBoxViewList.get(i).getPackingSlip());
				row.createCell(colAux3 + numColumn).setCellValue(dateString);

				numColumn = numColumn + 3;
				i++;
				if (i > (openBoxViewList.size() - 1)) {
					break;
				}

			}
			numColumn = 0;
		}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

	public void genOpenBoxAnalyticBoxes(ArrayList<OpenBoxView> openBoxViewList) throws IOException {

		String excelFileName = Constant.OPENBOX_REPORT_ANALYTIC_LIST;

		String sheetName = "AnalyticList";// name of sheet

		Integer xlsHeader = 0;

		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName);
		XSSFRow row = null;

		int i = 0;
		int lineNum = 0;
		while (i < (openBoxViewList.size() - 1)) {

			if (xlsHeader == 0) {
				row = sheet.createRow(lineNum);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("Item");
				row.createCell(2).setCellValue("QTY");
				xlsHeader = 1;
			}

			row = sheet.createRow(++lineNum);
			row.createCell(0).setCellValue(openBoxViewList.get(i).getIdItem());
			row.createCell(1).setCellValue(openBoxViewList.get(i).getItemName());
			row.createCell(2).setCellValue(Integer.valueOf(openBoxViewList.get(i).getQty().intValue()));
			i++;
		}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

}
