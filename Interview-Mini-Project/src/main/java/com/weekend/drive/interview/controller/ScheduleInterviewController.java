package com.weekend.drive.interview.controller;


import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weekend.drive.interview.bean.ScheduleInterview;
import com.weekend.drive.interview.bean.ScheduleInterviewListDto;
import com.weekend.drive.interview.repository.ScheduleInterviewRepository;
import com.weekend.drive.interview.request.ScheduleInterviewCreateRequest;
import com.weekend.drive.interview.request.ScheduleInterviewUpdateRequest;
import com.weekend.drive.interview.response.ApiResponse;
import com.weekend.drive.interview.service.impl.ScheduleInterviewServiceImpl;



@RestController
@CrossOrigin(origins="http://localhost:6868")
@RequestMapping("/api/interview")
public class ScheduleInterviewController {

	@Autowired
	private ScheduleInterviewServiceImpl scheduleInterviewServiceImpl;
	
	@Autowired
	ScheduleInterviewRepository scheduleInterviewRepository;
	
	//Find All Data
	@GetMapping("/schedule")
	public ResponseEntity<?> getAllScheduleInterview(){
		return new ResponseEntity<>(new ApiResponse<>(scheduleInterviewServiceImpl.getAllScheduleInterviewDto(),
				"All Interviewees"), HttpStatus.OK);
	}
	
	//Find All Data
	@GetMapping("/schedule/name")
	public ResponseEntity<?> getAllScheduleInterviewByName(){
		return new ResponseEntity<>(new ApiResponse<>(scheduleInterviewServiceImpl.getAllScheduleInterviewNameDto(),
				"All Interviewees"), HttpStatus.OK);
	}
	
	//Find Data By Id
	@GetMapping("/schedule/{id}")
	public Optional<ScheduleInterview> getScheduleInterviewById(@PathVariable int id){
		return scheduleInterviewServiceImpl.getScheduleInterviewById(id);
	}
		
	//Get Scheduled List
	@GetMapping("/schedule/list")
	public List<ScheduleInterviewListDto> getScheduledList(){
		return scheduleInterviewServiceImpl.getScheduledList();
	}
	
	//Get Scheduled List In Pagination
	@GetMapping("/schedule/list/{page}")
	public List<ScheduleInterviewListDto> getScheduledListPagination(@PathVariable int page){
		return scheduleInterviewServiceImpl.getScheduledListPagination(page);
	}
	
	//Create Resource
	@PostMapping("/add")
	public ResponseEntity<?> createScheduleInterview(@Validated @RequestBody ScheduleInterviewCreateRequest scheduleInterviewCreateRequest) throws IllegalAccessException, InvocationTargetException {
		return new ResponseEntity<>(new ApiResponse<>(scheduleInterviewServiceImpl.createScheduleInterview(scheduleInterviewCreateRequest).getId(),
				"Interview Scheduled Successfully"), HttpStatus.CREATED);
	}
	
	//Reschedule Status
	@PutMapping("/reschedule/{id}")
	public ResponseEntity<?> rescheduleStatus(@PathVariable int id) {
		return new ResponseEntity<>(new ApiResponse<>(scheduleInterviewServiceImpl.rescheduleStatus(id).getId(),
				"Interview Rescheduled Successfully"), HttpStatus.ACCEPTED);
	}
	
	//Change Status
	@PutMapping("/{id}/status")
	public ResponseEntity<?> setScheduleInterviewStatus(@PathVariable int id, @RequestBody String status){
		return new ResponseEntity<>(new ApiResponse<>(scheduleInterviewServiceImpl.setScheduleInterviewStatus(id, status).getId(),
				"Interview Status Updated Successfully"), HttpStatus.ACCEPTED);
	}	
	
	//Delete Resource By Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteScheduleInterview(@PathVariable int id) {
		scheduleInterviewServiceImpl.deleteScheduleInterview(id);
		return new ResponseEntity<>(new ApiResponse<>(id,"Interview Deleted Successfully"), HttpStatus.ACCEPTED);
	}
	
	//Update Resource
	@PutMapping("/update")
	public ResponseEntity<Object> updateScheduleInterview(@Validated @RequestBody ScheduleInterviewUpdateRequest scheduleInterviewUpdateRequest) throws IllegalAccessException, InvocationTargetException {
		return new ResponseEntity<>(new ApiResponse<>(scheduleInterviewServiceImpl.updateScheduleInterviewDto(scheduleInterviewUpdateRequest).getId(),"Interview Updated Successfully"), HttpStatus.ACCEPTED);
		
	}
	
}
