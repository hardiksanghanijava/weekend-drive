package com.WeekendDrive.Interview.Mini.Project.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WeekendDrive.Interview.Mini.Project.Bean.Interviewer;
import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterview;
import com.WeekendDrive.Interview.Mini.Project.Exception.InterviewAlreadyScheduled;
import com.WeekendDrive.Interview.Mini.Project.Exception.InterviewerNotFoundException;
import com.WeekendDrive.Interview.Mini.Project.Repository.InterviewerRepository;

@Service
public class InterviewerService {

	@Autowired
	private InterviewerRepository interviewerRepository;
	
	@Autowired
	private ScheduleInterviewService scheduleInterviewService;
	
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
			throw new InterviewerNotFoundException("Interviewer " + id + " Not Found");
		return interviewer;
	}
	
	//Create New record
	public void createInterviewer( Interviewer Interviewer) {
		Interviewer savedInterviewer = interviewerRepository.save(Interviewer);
		logger.info("Created Record : {}" + savedInterviewer);
		
	}
	
	//Delete Resource By Id
	public void deleteInterviewer( int id) {
		//Fetch interviewee if exist
				getInterviewerById(id);
				
				List<ScheduleInterview> scheduleInterview = scheduleInterviewService.getAllScheduleInterview();
				
				//Stream api loop
				scheduleInterview.stream().forEach(scheduleInterview2 -> 
				{if(scheduleInterview2.getInterviewee().getId()==id) {
					throw new InterviewAlreadyScheduled("Sorry you can't delete this interviewee, It's already scheduled");
				}}); 
				
				interviewerRepository.deleteById(id);
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
