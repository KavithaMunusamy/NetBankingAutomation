package com.netbanking.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Utility Class for Excel data operations
 * @author Kavitha M
 *
 */
public class ExcelUtility {
	Logger logger = LogManager.getLogger();
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	/**
	 * Constructor to get excel document for given excel path and
	 * get sheet for the given sheet name 
	 * 
	 * @param excelPath
	 * @param sheetName
	 */
	public ExcelUtility(String excelPath, String sheetName) {
		try {
			 workbook = new XSSFWorkbook(excelPath);
			 sheet = workbook.getSheet(sheetName);
			
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
	}
	
	/**
	 * Method to get the row count in the sheet
	 * @return
	 */
	public  int getRowCount() {
		int rowCount=0;
		rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
	
	/**
	 * Method to get the column count in the sheet
	 * @return
	 */
	public  int getColCount() {
		int colCount=0;
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}
	
	/**
	 * 	Method to get the data from a cell given row and column number
	 * @param rowNum
	 * @param colNum
	 * @return
	 */
	public  String getcellDataString(int rowNum, int colNum) {
		DataFormatter formatter = new DataFormatter();
		String cellData=null;
		cellData = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		return cellData;
		
	}
	
	/**
	 * Method to get data from excel in Object 2D Array
	 * @return
	 */
	public   Object[][] getExcelDataAsObjArray() {
		String cellData=null;
		int rowCount= getRowCount();
		int colCount= getColCount();
		
		Object[][] dataArray = new Object[rowCount-1][colCount];
		for (int i=1; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				cellData=getcellDataString(i, j);
				dataArray[i-1][j]=cellData;
			}
		}
		logger.debug("Data retrived from Excel document for Sheet:"+ sheet.getSheetName());
		return dataArray;
	}
	
	/**
	 * Method to get data from excel as Iterator of object array
	 * @param excelpath
	 * @return
	 */
	public  Iterator<Object[]> getExcelDataAsIterObjArray() {
		List<Map<String, String>> detailsList = new ArrayList<Map<String, String>>();
		Map<String, String> fieldsMap;
		
		int rowCount = getRowCount();
		int colCount = getColCount();
		for (int j = 1; j < colCount; j++) {
			fieldsMap = new HashMap<String, String>();
			for (int i = 1; i < rowCount; i++) {
				fieldsMap.put(getcellDataString(i, 0), getcellDataString(i, j));
			}
			detailsList.add(fieldsMap);
		}
		
		Collection<Object[]> dp = new ArrayList<Object[]>(); 
        for(Map<String,String> map:detailsList){
            dp.add(new Object[]{map});
        }
        logger.debug("Data retrived from Excel document for Sheet:"+ sheet.getSheetName());
        return dp.iterator();

	}
	
	/**
	 * gets the list of sheets available in excel
	 * @param workbook
	 * @return
	 */
	public List<XSSFSheet> getSheet(XSSFWorkbook workbook) {
		int noOfSheets= workbook.getNumberOfSheets();
		List<XSSFSheet> sheetList = new ArrayList<XSSFSheet>();
		for(int i=0;i<noOfSheets; i++ ) {
			sheetList.add(workbook.getSheetAt(i));
		}
		return sheetList;
	}
		
	
	
	
	

}
