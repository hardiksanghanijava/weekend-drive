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
	private InterviewerRepository interviewerRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Retrieve all records from database
	public List<Interviewer> getAllInterviewers(){
		List<Interviewer> interviewers = interviewerRepository.findAll();
		logger.info("All Retieved Records :{} " + interviewers);
		return interviewers;
	}
	
	//find by id method
	public Optional<Interviewer> getInterviewerById( int id){
		Optional<Interviewer> interviewer = interviewerRepository.findById(id);
		logger.info("record by id : {}" + interviewer);
		if(interviewer.isEmpty())
			throw new InterviewerNotFoundException("Resource " + id + " Not Found");
		return interviewer;
	}
	
	//Create New record
	public void createInterviewer( Interviewer Interviewer) {
		Interviewer savedInterviewer = interviewerRepository.save(Interviewer);
		logger.info("Created Record : {}" + savedInterviewer);
		
	}
	
	//Delete Resource By Id
	public void deleteInterviewer( int id) {
		Optional<Interviewer> interviewer = interviewerRepository.findById(id);
		if(interviewer.isEmpty())
			throw new InterviewerNotFoundException("Resource " + id + " Not Found");
		else {
			logger.info("Deleted resource : {}" + interviewer);
			interviewerRepository.deleteById(id);
		}
	}
	
	//Update existing resource
	public void updateInterviewer( Interviewer Interviewer) {
		Optional<Interviewer> interviewer = interviewerRepository.findById(Interviewer.getId());
		if(interviewer.isPresent()) {
			logger.info("Updated Resource From : " + interviewer );
			Interviewer updatedInterviewer = interviewerRepository.save(Interviewer);
			logger.info("To : " + updatedInterviewer);
			
		}
		else
			throw new InterviewerNotFoundException("Resource " + Interviewer.getId() + " not found for updation");
	}
	
	
	
	
}
