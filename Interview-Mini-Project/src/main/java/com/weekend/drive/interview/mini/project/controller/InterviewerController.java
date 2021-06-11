package  com.weekend.drive.interview.mini.project.controller;


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

import com.weekend.drive.interview.mini.project.bean.Interviewer;
import com.weekend.drive.interview.mini.project.service.InterviewerService;


@RestController
@RequestMapping("/api/interviewer")
public class InterviewerController {

	@Autowired
	private InterviewerService interviewerService;
	
	//retrieve All Data
	@GetMapping("/list")
	public List<Interviewer> getAllInterviewer(){
		return interviewerService.getAllInterviewers();
	}
	
	//Find Data By Id
	@GetMapping("/view/{id}")
	public Optional<Interviewer> getInterviewerById(@PathVariable int id){
		return interviewerService.getInterviewerById(id);
	}
	
	//Create Resource
	@PostMapping("/add")
	public ResponseEntity<Object> createInterviewer(@Validated @RequestBody Interviewer interviewer) {
		interviewerService.createInterviewer(interviewer);
		return new ResponseEntity<Object>("Interviewer Created Successfully", HttpStatus.ACCEPTED);
	}
	
	//Delete Resource By Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) {
		interviewerService.deleteInterviewer(id);
		return new ResponseEntity<Object>("Interviewer Deleted Successfully", HttpStatus.ACCEPTED);
	}
	
	//Update Resource
	@PutMapping("/update")
	public ResponseEntity<Object> updateInterviewer(@Validated @RequestBody Interviewer interviewer) {
		interviewerService.updateInterviewer(interviewer);
		return new ResponseEntity<Object>("Interviewer Updated Successfully", HttpStatus.ACCEPTED);
	}
	
	
	
	
}
