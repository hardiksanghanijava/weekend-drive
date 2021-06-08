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

import com.WeekendDrive.Interview.Mini.Project.Bean.Interviewee;
import com.WeekendDrive.Interview.Mini.Project.Exception.IntervieweeNotFoundException;
import com.WeekendDrive.Interview.Mini.Project.Repository.IntervieweeRepository;

@Service
public class IntervieweeService {

	@Autowired
	private IntervieweeRepository repository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	//Retrieve all records from database
	public List<Interviewee> findAll(){
		List<Interviewee> find = repository.findAll();
		log.info("All Retieved Records : " + find);
		return find;
	}
	
	//Retrieve records by id
	public Optional<Interviewee> findById(@PathVariable int id){
		Optional<Interviewee> user = repository.findById(id);
		log.info("Find record by id : " + user);
		if(user.isEmpty())
			throw new IntervieweeNotFoundException("Resource " + id + " Not Foud");
		return user;
	}
	
	//Create New Resource
	public ResponseEntity<Object> createInterviewee(@Validated @RequestBody Interviewee interviewee) {
		Interviewee save = repository.save(interviewee);
		log.info("Created Resource : " + save);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	//Delete Resource By Id
	public void deleteById(@PathVariable int id) {
		Optional<Interviewee> user = repository.findById(id);
		if(user.isEmpty())
			throw new IntervieweeNotFoundException("Resource " + id + " Not Found");
		else {
			log.info("Deleted resource : " + user);
			repository.deleteById(id);
		}
	}
	
	//Update existing resource
	public ResponseEntity<Object> updateInterviewee(@Validated @RequestBody Interviewee interviewee) {
		Optional<Interviewee> user = repository.findById(interviewee.getId());
		if(user.isPresent()) {
			log.info("Updated Resource From : " + user );
			Interviewee update = repository.save(interviewee);
			log.info("To : " + update);
			return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		}
		else
			throw new IntervieweeNotFoundException("Resource " + interviewee.getId() + " not fond for updatation");
	}
	
	
	
	
}
