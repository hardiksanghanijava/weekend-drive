package com.weekend.drive.interview.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.InputStreamResource;

import com.weekend.drive.interview.response.ScheduleInterviewNameResponse;

public interface ExportToExcelService {

	public ByteArrayInputStream interviewToExcel(List<ScheduleInterviewNameResponse> scheduleInterview) throws IOException;
	
	public InputStreamResource export() throws IOException;

}
