package com.WeekendDrive.Interview.Mini.Project.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterview;
import com.WeekendDrive.Interview.Mini.Project.Exception.IntervieweeNotFoundException;
import com.WeekendDrive.Interview.Mini.Project.Repository.ScheduleInterviewRepository;

@Service
public class ScheduleInterviewService {

	@Autowired
	private ScheduleInterviewRepository repository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	//Retrieve all records from database
	public List<ScheduleInterview> findAll(){
		List<ScheduleInterview> find =  repository.findAll();
		log.info("All Retieved Records : " + find);
		return find;
	}
	
	//Retrieve records by id
	public Optional<ScheduleInterview> findById(int id){
		Optional<ScheduleInterview> user = repository.findById(id);
		log.info("Find record by id : " + user);
		if(user.isEmpty())
			throw new IntervieweeNotFoundException("Resource " + id + " Not Foud");
		return user;
	}
	
	//Create New Resource
	public ResponseEntity<Object> createInterviewee(ScheduleInterview scheduleInterview) {
		ScheduleInterview save = repository.save(scheduleInterview);
		log.info("Created Resource : " + save);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	//Delete Resource By Id
	public void deleteById(@PathVariable int id) {
		Optional<ScheduleInterview> user = repository.findById(id);
		if(user.isEmpty())
			throw new IntervieweeNotFoundException("Resource " + id + " Not Found");
		else {
			log.info("Deleted resource : " + user);
			repository.deleteById(id);
		}
	}
	
	//Update existing resource
	public ResponseEntity<Object> updateInterviewee(int id, ScheduleInterview scheduleInterview) {
		Optional<ScheduleInterview> user = repository.findById(id);
		if(user.isPresent()) {
			log.info("Updated Resource From : " + user );
			ScheduleInterview update = repository.save(scheduleInterview);
			log.info("To : " + update);
			return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		}
		else
			throw new IntervieweeNotFoundException("Resource " + scheduleInterview.getId() + " not fond for updatation");
	}
	
	
}
