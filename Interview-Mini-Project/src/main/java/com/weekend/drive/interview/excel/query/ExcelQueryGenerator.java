package com.weekend.drive.interview.excel.query;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.beans.factory.annotation.Value;


public class ExcelQueryGenerator {
	
	public String path = "G:/weekend-drive/Excel/";

	Workbook workbook;
	
	//Table name of Database
	public String tableName = "WeekendDrive";

	public static void main(String[] args) throws NumberFormatException, ParseException, EncryptedDocumentException, IOException {
		
		ExcelQueryGenerator obj = new ExcelQueryGenerator();
		obj.exportToExcel(obj.getExcelDataAsList());
		
	}

	public List<String> getExcelDataAsList() throws NumberFormatException, ParseException, EncryptedDocumentException, IOException {

		List<String> data = new ArrayList<String>();
		List<String> header = new ArrayList<String>();
		List<ExcelDao> excelList = new ArrayList<>();
		

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// Create the Workbook
		workbook = WorkbookFactory.create(new File(path + "example.xlsx"));

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Getting number of columns in the Sheet
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		//Creating Excel Header List
		for(Cell cell : sheet.getRow(0)) {
			String cellValue = dataFormatter.formatCellValue(cell);
			header.add(cellValue);
		}
		
		//Creating Excel Data List
		for(int i=1; i<=sheet.getLastRowNum(); i++) {
			for(Cell cell : sheet.getRow(i)) {
				String cellValue = dataFormatter.formatCellValue(cell);
				data.add(cellValue);
			}
		}
		
		int i = 0;
		do {
				excelList.add(new ExcelDao(Integer.valueOf(data.get(i)), data.get(i+1), data.get(i+2).charAt(0),new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data.get(i+3))));
				i = i + (noOfColumns);
			
			} while (i < data.size());
		
		//Creating SQL List
		List<String> sqlList = new ArrayList<>();
	
		//SQL Queries Generation...
		String sql = "insert into " + tableName + "(";
		
		for(int j=0; j<header.size()-1; j++) {
			sql = sql + header.get(j) + ",";
		}
		
		sql = sql + header.get(header.size()-1) +") values(";
		
		for(ExcelDao excelData : excelList) {
			String sql1 = sql + excelData.getId() + ",'" + excelData.getName() +"','" + excelData.getGender() +"','"+ excelData.getDate() +"')"; 
			sqlList.add(sql1);
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
