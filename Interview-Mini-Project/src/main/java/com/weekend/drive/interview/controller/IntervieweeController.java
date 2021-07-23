package com.weekend.drive.interview.controller;

import java.lang.reflect.InvocationTargetException;

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

import com.weekend.drive.interview.request.IntervieweeCreateRequest;
import com.weekend.drive.interview.request.IntervieweeUpdateRequest;
import com.weekend.drive.interview.response.ApiResponse;
import com.weekend.drive.interview.service.IntervieweeService;

@RestController
@CrossOrigin(origins="http://localhost:6868")
@RequestMapping("/api/interviewee")
public class IntervieweeController {

	@Autowired
	private IntervieweeService intervieweeService;

	
	// Find All Data
	@GetMapping("/list")
	public ResponseEntity<?> getAllInterviewee() {
		return new ResponseEntity<>(new ApiResponse<>(intervieweeService.getAllInterviewee(),
				"All Interviewees"), HttpStatus.OK);
	}

	// Find Data By Id
	@GetMapping("/view/{id}")
	public ResponseEntity<?> getIntervieweeById(@PathVariable int id) throws IllegalAccessException, InvocationTargetException {
				return new ResponseEntity<>(new ApiResponse<>(intervieweeService.getIntervieweeById(id),
				"Interviewee Presente at this id " + id), HttpStatus.OK);
	}
	
	// Find Data By Name
		@GetMapping("/view/name/{name}")	
		public ResponseEntity<?> getIntervieweeByName(@PathVariable String name) throws IllegalAccessException, InvocationTargetException {
					return new ResponseEntity<>(new ApiResponse<>(intervieweeService.findByIntervieweeName(name),
					"Interviewee Presente at this name " + name), HttpStatus.OK);
		}
		
		
	// Create Resource
	@PostMapping("/add")
	public ResponseEntity<?> createInterviewee(@Validated @RequestBody IntervieweeCreateRequest intervieweeCreateRequest)
			throws IllegalAccessException, InvocationTargetException {
		return new ResponseEntity<>(new ApiResponse<>(intervieweeService.createInterviewee(intervieweeCreateRequest).getId(),
				"Interviewee Created Successfully"), HttpStatus.CREATED);
	}

	// Delete Resource By Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteInterviewee(@PathVariable int id) throws IllegalAccessException, InvocationTargetException {
		intervieweeService.deleteInterviewee(id);
		return new ResponseEntity<>(new ApiResponse<>(id,
				"Interviewee Deleted Successfully"), HttpStatus.ACCEPTED);
	}

	//Update Resource
	@PutMapping("/update")
	public ResponseEntity<?> updateInterviewee(@Validated @RequestBody IntervieweeUpdateRequest intervieweeUpdateRequest) throws IllegalAccessException, InvocationTargetException {
		return new ResponseEntity<>(new ApiResponse<>(intervieweeService.updateInterviewee(intervieweeUpdateRequest).getId(), 
				"Interviewee Updated Successfully"), HttpStatus.ACCEPTED);
	}

}
