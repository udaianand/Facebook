package com.googleform.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * Reads excel data as get as List.
 * 
 * Note: First row being Header is skipped as part of the List.
 * 
 * @author UdaiAnand
 *
 * 
 */

public class Upload {
	private File file;

	public Upload(File file) {
		this.file = file;
	}

	public ArrayList<ArrayList<Object>> extractAsList() {

		ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
		int maxDataCount = 0;

		try {
			FileInputStream file = new FileInputStream(this.file);

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row xRow = rowIterator.next();
				// Skip the first row because it is headers
				if (xRow.getRowNum() == 0) {
					maxDataCount = xRow.getLastCellNum();
					continue;
				}

				// if row is empty then break the loop,do not go further
				if (this.isRowEmpty(xRow, maxDataCount)) {
					break;
				}

				ArrayList<Object> singleRows = new ArrayList<Object>();

				// For each row, iterate through all the columns
				for (int ColNum = 0; ColNum < maxDataCount; ColNum++) {
					Cell xCell = xRow.getCell(ColNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

					switch (xCell.getCellType()) {
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(xCell)) {
							singleRows.add(new SimpleDateFormat("yyyy-MM-dd").format(xCell.getDateCellValue()));
						} else
							singleRows.add(xCell.getNumericCellValue());
						break;

					case STRING:
						singleRows.add(xCell.getStringCellValue());
						break;

					case BLANK:
						singleRows.add(null);
						break;

					default:
						singleRows.add(xCell.getStringCellValue());

					}
				}
				list.add(singleRows);
			}
			file.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public boolean isRowEmpty(Row xRow, int lastcellno) {

		for (int ColNum = xRow.getFirstCellNum(); ColNum < lastcellno; ColNum++) {

			Cell xCell = xRow.getCell(ColNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (xCell != null && xCell.getCellType() != CellType.BLANK)

				return false;

		}

		return true;

	}

}
