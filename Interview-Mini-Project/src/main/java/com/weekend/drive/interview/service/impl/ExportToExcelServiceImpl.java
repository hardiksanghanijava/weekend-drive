package com.weekend.drive.interview.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import com.weekend.drive.interview.response.ScheduleInterviewNameResponse;
import com.weekend.drive.interview.service.ExportToExcelService;

@Service
public class ExportToExcelServiceImpl implements ExportToExcelService {
	
	@Autowired
	ScheduleInterviewServiceImpl scheduleInterviewServiceImpl;
	
	public ByteArrayInputStream interviewToExcel(List<ScheduleInterviewNameResponse> scheduleInterview) throws IOException {
		String[] COLUMNs = {"Id", "IntervieweeName", "InterviewerName", "PositionsName", "RoundName", "Time", "Status"};
		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
			@SuppressWarnings("unused")
			CreationHelper createHelper = workbook.getCreationHelper();
	 
			Sheet sheet = workbook.createSheet("ScheduleInterview");
	 
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
	 
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
	 
			// Row for Header
			Row headerRow = sheet.createRow(0);
	 
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
			
			List<ScheduleInterviewNameResponse> scheduleInterviewList = scheduleInterview;

			int rowIdx = 0;
			for(ScheduleInterviewNameResponse interview : scheduleInterviewList) {
				rowIdx++;
				Row row = sheet.createRow(rowIdx);
	 
				row.createCell(0).setCellValue(interview.getId());
				row.createCell(1).setCellValue(interview.getIntervieweeName());
				row.createCell(2).setCellValue(interview.getInterviewerName());
				row.createCell(3).setCellValue(interview.getPositionsName());
				row.createCell(4).setCellValue(interview.getRoundName());
				row.createCell(5).setCellValue(interview.getTime().toString());
				row.createCell(6).setCellValue(interview.getStatus());
			};
	 
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	public InputStreamResource export() throws IOException {
		
		List<ScheduleInterviewNameResponse> scheduleInterview =scheduleInterviewServiceImpl.getAllScheduleInterviewNameDto();
		 
		ByteArrayInputStream in = interviewToExcel(scheduleInterview);
		
		
		return new InputStreamResource(in);
	}
		

}
