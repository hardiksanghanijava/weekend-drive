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

import com.WeekendDrive.Interview.Mini.Project.Bean.Interviewee;
import com.WeekendDrive.Interview.Mini.Project.Service.IntervieweeService;


@RestController
@RequestMapping("/api/interviewee")
public class IntervieweeController {

	@Autowired
	private IntervieweeService intervieweeService;
	
	//Find All Data
	@GetMapping("/list")
	public List<Interviewee> getAllInterviewee(){
		return intervieweeService.getAllInterviewee();
	}
	
	//Find Data By Id
	@GetMapping("/view/{id}")
	public Optional<Interviewee> getIntervieweeById(@PathVariable int id){
		return intervieweeService.getIntervieweeById(id);
	}
	
	//Create Resource
	@PostMapping("/add")
	public ResponseEntity<Object> createInterviewee(@Validated @RequestBody Interviewee interviewee) {
		intervieweeService.createInterviewee(interviewee);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	//Delete Resource By Id
	@DeleteMapping("/delete/{id}")
	public void deleteInterviewee(@PathVariable int id) {
		intervieweeService.deleteInterviewee(id);
	}
	
	//Update Resource
	@PutMapping("/update")
	public ResponseEntity<Object> updateInterviewee(@Validated @RequestBody Interviewee interviewee) {
		intervieweeService.updateInterviewee(interviewee);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
	
	
	
	
}
