package com.weekend.drive.interview.excel.query;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelQueryGeneratorUtility {
	
	public String path = "G:/weekend-drive/Excel/"; // Path of file

	Workbook workbook;
	
	//Table name of Database
	public String tableName = "WeekendDrive";

	public static void main(String[] args) throws NumberFormatException, ParseException, EncryptedDocumentException, IOException {
		
		ExcelQueryGeneratorUtility obj = new ExcelQueryGeneratorUtility();
		obj.exportToExcel(obj.getExcelDataAsList());
		
	}

	public List<String> getExcelDataAsList() throws NumberFormatException, ParseException, EncryptedDocumentException, IOException {

		List<String> dataType = new ArrayList<String>();
		List<String> header = new ArrayList<String>();
		List<String> sqlList = new ArrayList<>();

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// Create the Workbook
		workbook = WorkbookFactory.create(new File(path + "example3.xlsx")); // File name for input

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Getting number of columns in the Sheet
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		//Creating Excel Header List
		for(Cell cell : sheet.getRow(0)) {
			String cellValue = dataFormatter.formatCellValue(cell);
			header.add(cellValue);
		}
		
		//Creating Data type List
		for(Cell cell : sheet.getRow(1)) {
			String cellValue = dataFormatter.formatCellValue(cell);
			dataType.add(cellValue);
		}
	
		//SQL Queries Generation...
		String sql = "insert into " + tableName + "(";
		
		for(int j=0; j<header.size()-1; j++) {
			sql = sql + header.get(j) + ",";
		}
		
		sql = sql + header.get(header.size()-1) +") values(";
		
		//Creating Excel Data List
		for(int i=2; i<=sheet.getLastRowNum(); i++) {
			String insertValue = "";
			
			for(int j=0; j<noOfColumns; j++) {
				
				String cellValue = sheet.getRow(i).getCell(j).toString();
				
				if(dataType.get(j).toLowerCase().equals("int")) {
					float floatValue = Float.parseFloat(cellValue);
					insertValue += (int) floatValue;
				}
				else if(dataType.get(j).toLowerCase().equals("long") || dataType.get(j).toLowerCase().equals("float")) {
					insertValue += cellValue; 
				}
				else {
					insertValue += "'" + cellValue + "'"; 
				}
				
				
				if(j!=noOfColumns-1) {
					insertValue += ",";
				}
				else { 
					insertValue += ")";
				}
				
			}
			
			insertValue = sql + insertValue; 
			sqlList.add(insertValue);
			
		}

		// Closing the workbook
		workbook.close();

		return sqlList;
	}
	
	public void exportToExcel(List<String> sqlList) throws IOException {
		
			Workbook workbook = new XSSFWorkbook();
				
			@SuppressWarnings("unused")
			CreationHelper createHelper = workbook.getCreationHelper();
	 
			Sheet sheet = workbook.createSheet("InsertQueires");

			int rowIdx = 0;
			for(String sql : sqlList) {
				Row row = sheet.createRow(rowIdx);
				row.createCell(0).setCellValue(sql);
				rowIdx++;
			};
	 
			FileOutputStream out = new FileOutputStream(new File(path + "InsertQueries.xlsx"));
			workbook.write(out);
			out.close();	
			workbook.close();
		    System.out.println("InsertQueries.xlsx written successfully on disk.");
	}

}
