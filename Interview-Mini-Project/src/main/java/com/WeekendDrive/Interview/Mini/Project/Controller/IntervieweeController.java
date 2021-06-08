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

import com.WeekendDrive.Interview.Mini.Project.Bean.Interviewee;
import com.WeekendDrive.Interview.Mini.Project.Service.IntervieweeService;


@RestController
@RequestMapping("/api/interviewee")
public class IntervieweeController {

	@Autowired
	private IntervieweeService service;
	
	//Find All Data
	@GetMapping("/list")
	public List<Interviewee> findAll(){
		return service.findAll();
	}
	
	//Find Data By Id
	@GetMapping("/view/{id}")
	public Optional<Interviewee> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	//Create Resource
	@PostMapping("/add")
	public ResponseEntity<Object> createInterviewee(@Validated @RequestBody Interviewee interviewee) {
		return service.createInterviewee(interviewee);
	}
	
	//Delete Resource By Id
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	//Update Resource
	@PutMapping("/update")
	public ResponseEntity<Object> updateInterviewee(@Validated @RequestBody Interviewee interviewee) {
		return service.updateInterviewee(interviewee);
	}
	
	
	
	
}
