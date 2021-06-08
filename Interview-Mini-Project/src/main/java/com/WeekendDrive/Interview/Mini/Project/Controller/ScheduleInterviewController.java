package com.WeekendDrive.Interview.Mini.Project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	private ScheduleInterviewService service;
	
	//Find All Data
	@GetMapping("/schedule")
	public List<ScheduleInterview> findAll(){
		return service.findAll();
	}
	
	//Find Data By Id
	@GetMapping("/schedule/{id}")
	public Optional<ScheduleInterview> findById(@PathVariable int id){
		return service.findById(id);
	}
		
	//Create Resource
	@PostMapping("/add")
	public ResponseEntity<Object> createInterviewee(@Validated @RequestBody ScheduleInterview scheduleInterview) {
		return service.createInterviewee(scheduleInterview);
	}
	
	//Delete Resource By Id
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	//Update Resource
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateInterviewee(@Validated @PathVariable int id, @RequestBody ScheduleInterview scheduleInterview) {
		return service.updateInterviewee(id, scheduleInterview);
	}
	
	
	
	
}
