package com.weekend.drive.interview.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import com.weekend.drive.interview.bean.ScheduleInterview;
import com.weekend.drive.interview.bean.ScheduleInterviewDto;
import com.weekend.drive.interview.bean.ScheduleInterviewListDto;
import com.weekend.drive.interview.request.ScheduleInterviewCreateRequest;
import com.weekend.drive.interview.request.ScheduleInterviewUpdateRequest;
import com.weekend.drive.interview.response.ScheduleInterviewResponse;

public interface ScheduleInterviewService {
	
	//Retrieve all scheduled interview
	public List<ScheduleInterviewResponse> getAllScheduleInterviewDto();
	
	//Retrieve Scheduled Interview List
	public List<ScheduleInterviewListDto> getScheduledList();
	
	//Create new scheduled interview
	ScheduleInterviewDto createScheduleInterview(ScheduleInterviewCreateRequest scheduleInterviewCreateRequest)
			throws IllegalAccessException, InvocationTargetException;
	
	//Change Status to Reschedule 
	public ScheduleInterview rescheduleStatus(int id);
	
	//Change Status of Schedule Interview
	public ScheduleInterview setScheduleInterviewStatus(int id, String status);
	
	//Delete scheduled interview by id
	public void deleteScheduleInterview(int id);
	
	//Update existing scheduled interview
	public ScheduleInterviewDto updateScheduleInterviewDto(ScheduleInterviewUpdateRequest scheduleInterviewUpdateRequest) throws IllegalAccessException, InvocationTargetException;
	
	
	//Retrieve Scheduled Interview List
	public List<ScheduleInterviewListDto> getScheduledListPagination(int page);

	Optional<ScheduleInterview> getScheduleInterviewById(int id);

	

}
