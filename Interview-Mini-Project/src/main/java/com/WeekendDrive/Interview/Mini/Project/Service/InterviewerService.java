package com.WeekendDrive.Interview.Mini.Project.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.WeekendDrive.Interview.Mini.Project.Bean.Interviewer;
import com.WeekendDrive.Interview.Mini.Project.Exception.InterviewerNotFoundException;
import com.WeekendDrive.Interview.Mini.Project.Repository.InterviewerRepository;

@Service
public class InterviewerService {

	@Autowired
	private InterviewerRepository repository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Retrieve all records from database
	public List<Interviewer> findAll(){
		List<Interviewer> find = repository.findAll();
		logger.info("All Retieved Records :{} " + find);
		return find;
	}
	
	//find by id method
	public Optional<Interviewer> findById(@PathVariable int id){
		Optional<Interviewer> user = repository.findById(id);
		logger.info("record by id : {}" + user);
		if(user.isEmpty())
			throw new InterviewerNotFoundException("Resource " + id + " Not Found");
		return user;
	}
	
	//Create New record
	public ResponseEntity<Object> createInterviewer(@Validated @RequestBody Interviewer Interviewer) {
		Interviewer save = repository.save(Interviewer);
		logger.info("Created Record : {}" + save);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	//Delete Resource By Id
	public void deleteById(@PathVariable int id) {
		Optional<Interviewer> user = repository.findById(id);
		if(user.isEmpty())
			throw new InterviewerNotFoundException("Resource " + id + " Not Found");
		else {
			logger.info("Deleted resource : {}" + user);
			repository.deleteById(id);
		}
	}
	
	//Update existing resource
	public ResponseEntity<Object> updateInterviewer(@Validated @RequestBody Interviewer Interviewer) {
		Optional<Interviewer> user = repository.findById(Interviewer.getId());
		if(user.isPresent()) {
			logger.info("Updated Resource From : " + user );
			Interviewer update = repository.save(Interviewer);
			logger.info("To : " + update);
			return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		}
		else
			throw new InterviewerNotFoundException("Resource " + Interviewer.getId() + " not found for updation");
	}
	
	
	
	
}
