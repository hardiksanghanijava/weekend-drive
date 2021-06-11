package  com.weekend.drive.interview.controller;


import java.lang.reflect.InvocationTargetException;

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

import com.weekend.drive.interview.request.InterviewerCreateRequest;
import com.weekend.drive.interview.request.InterviewerUpdateRequest;
import com.weekend.drive.interview.response.ApiResponse;
import com.weekend.drive.interview.service.impl.InterviewerServiceImpl;


@RestController
@RequestMapping("/api/interviewer")
public class InterviewerController {

	@Autowired
	private InterviewerServiceImpl interviewerServiceImpl;
	
	// Find All Data
	@GetMapping("/list")
	public ResponseEntity<?> getAllInterviewer() {
		return new ResponseEntity<>(new ApiResponse<>(interviewerServiceImpl.getAllInterviewer(),
				"All Interviewers"), HttpStatus.OK);	
	}
	
	// Find Data By Id
	@GetMapping("/view/{id}")
	public ResponseEntity<?> getInterviewerById(@PathVariable int id) throws IllegalAccessException, InvocationTargetException {
		return new ResponseEntity<>(new ApiResponse<>(interviewerServiceImpl.getInterviewerById(id),
					"Interviewer Presente at this id " + id), HttpStatus.OK);
		}
	
	// Create Resource
	@PostMapping("/add")
	public ResponseEntity<?> createInterviewer(@Validated @RequestBody InterviewerCreateRequest interviewerCreateRequest)
			throws IllegalAccessException, InvocationTargetException {
		return new ResponseEntity<>(new ApiResponse<>(interviewerServiceImpl.createInterviewer(interviewerCreateRequest).getId(),
				"Interviewer Created Successfully"), HttpStatus.CREATED);
	}

	
	// Delete Resource By Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteInterviewer(@PathVariable int id) throws IllegalAccessException, InvocationTargetException {
		interviewerServiceImpl.deleteInterviewer(id);
		return new ResponseEntity<>(new ApiResponse<>(id,
				"Interviewer Delete Successfully"), HttpStatus.ACCEPTED);
	}
	
	//Update Resource
	@PutMapping("/update")
	public ResponseEntity<?> updateInterviewer(@Validated @RequestBody InterviewerUpdateRequest interviewerUpdateRequest) throws IllegalAccessException, InvocationTargetException {
		return new ResponseEntity<>(new ApiResponse<>(interviewerServiceImpl.updateInterviewer(interviewerUpdateRequest).getId(), 
				"Interviewer Updated Successfully"), HttpStatus.ACCEPTED);
	}
}
