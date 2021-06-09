package com.WeekendDrive.Interview.Mini.Project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterview;
import com.WeekendDrive.Interview.Mini.Project.Service.ScheduleInterviewService;


@RestController
@RequestMapping("/api/interview")
public class ScheduleInterviewController {

	@Autowired
	private ScheduleInterviewService scheduleInterviewService;
	
	//Find All Data
	@GetMapping("/schedule")
	public List<ScheduleInterview> getAllScheduleInterview(){
		return scheduleInterviewService.getAllScheduleInterview();
	}
	
	//Find Data By Id
	@GetMapping("/schedule/{id}")
	public Optional<ScheduleInterview> getScheduleInterviewById(@PathVariable int id){
		return scheduleInterviewService.getScheduleInterviewById(id);
	}
		
	//Create Resource
	@PostMapping("/add")
	public ResponseEntity<Object> createScheduleInterview(@Validated @RequestBody ScheduleInterview scheduleInterview) {
		scheduleInterviewService.createScheduleInterview(scheduleInterview);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	//Delete Resource By Id
	@DeleteMapping("/delete/{id}")
	public void deleteScheduleInterview(@PathVariable int id) {
		scheduleInterviewService.deleteScheduleInterview(id);
	}
	
	//Update Resource
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateScheduleInterview(@Validated @PathVariable int id, @RequestBody ScheduleInterview scheduleInterview) {
		scheduleInterviewService.updateScheduleInterview(id, scheduleInterview);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
	
	
	
	
}
