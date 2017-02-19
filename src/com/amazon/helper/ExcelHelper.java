package com.amazon.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	static Logger logger = LogManager.getLogger(ExcelHelper.class);

	@SuppressWarnings("resource")
	public static Object[][] getData() {
		Object[][] data;
		try {
			XSSFWorkbook book = new XSSFWorkbook(
					new FileInputStream(
							new File(
									"H:\\Users\\Hanshika\\gomathy_java\\SeleniumAutomationLearns\\resources\\testdata.xlsx")));
			XSSFSheet sheet = book.getSheetAt(0);
			int numberOfRows = sheet.getLastRowNum();
			data = new Object[numberOfRows][2];
			System.out.println("no of rows:" + numberOfRows);
			Row topRow = sheet.getRow(0);
			sheet.removeRow(topRow);
			Iterator<Row> rows = sheet.iterator();
			int i = 0;
			while (rows.hasNext()) {
				int j = 0;
				Row row = rows.next();
				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					data[i][j] = cell.getStringCellValue();

					j++;

				}
				i++;
			}

			return data;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
}
