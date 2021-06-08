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

import com.WeekendDrive.Interview.Mini.Project.Bean.Interviewer;
import com.WeekendDrive.Interview.Mini.Project.Service.InterviewerService;


@RestController
@RequestMapping("/api/interviewer")
public class InterviewerController {

	@Autowired
	private InterviewerService service;
	
	//retrieve All Data
	@GetMapping("/list")
	public List<Interviewer> findAll(){
		return service.findAll();
	}
	
	//Find Data By Id
	@GetMapping("/view/{id}")
	public Optional<Interviewer> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	//Create Resource
	@PostMapping("/add")
	public ResponseEntity<Object> createInterviewer(@Validated @RequestBody Interviewer interviewer) {
		return service.createInterviewer(interviewer);
	}
	
	//Delete Resource By Id
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	//Update Resource
	@PutMapping("/update")
	public ResponseEntity<Object> updateInterviewer(@Validated @RequestBody Interviewer interviewer) {
		return service.updateInterviewer(interviewer);
	}
	
	
	
	
}
