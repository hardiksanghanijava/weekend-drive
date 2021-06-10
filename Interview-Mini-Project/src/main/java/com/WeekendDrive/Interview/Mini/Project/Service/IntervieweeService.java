package com.WeekendDrive.Interview.Mini.Project.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WeekendDrive.Interview.Mini.Project.Bean.Interviewee;
import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterview;
import com.WeekendDrive.Interview.Mini.Project.Exception.InterviewAlreadyScheduled;
import com.WeekendDrive.Interview.Mini.Project.Exception.IntervieweeNotFoundException;
import com.WeekendDrive.Interview.Mini.Project.Repository.IntervieweeRepository;

@Service
public class IntervieweeService {

	@Autowired
	private IntervieweeRepository intervieweeRepository;
	
	@Autowired
	private ScheduleInterviewService scheduleInterviewService;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	//Retrieve all interviewee
	public List<Interviewee> getAllInterviewee(){
		List<Interviewee> interviewees = intervieweeRepository.findAll();
		log.info("All Retieved Records : " + interviewees);
		return interviewees;
	}
	
	//Retrieve interviewee by id
	public Optional<Interviewee> getIntervieweeById(int id){
		Optional<Interviewee> interviewee = intervieweeRepository.findById(id);
		log.info("Find record by id : " + interviewee);
		if(interviewee.isEmpty())
			throw new IntervieweeNotFoundException("Interviewee " + id + " Not Foud");
		return interviewee;
	}
	
	//Create new interviewee
	public void createInterviewee(Interviewee interviewee) {
		Interviewee saveInterviewee = intervieweeRepository.save(interviewee);
		log.info("Created Resource : " + saveInterviewee);
	}
	
	//Delete interviewee by id
	public void deleteInterviewee(int id) {
		//Fetch interviewee if exist
		getIntervieweeById(id);
		
		List<ScheduleInterview> scheduleInterview = scheduleInterviewService.getAllScheduleInterview();
		
		//Stream api loop
		scheduleInterview.stream().forEach(scheduleInterview2 -> 
		{if(scheduleInterview2.getInterviewee().getId()==id) {
			throw new InterviewAlreadyScheduled("Sorry you can't delete this interviewee, It's already scheduled");
		}}); 
		
		intervieweeRepository.deleteById(id);
	}
	
	//Update existing interviewee
	public void updateInterviewee(Interviewee interviewee) {
		Optional<Interviewee> user = intervieweeRepository.findById(interviewee.getId());
		if(user.isPresent()) {
			log.info("Updated Resource From : " + user );
			Interviewee update = intervieweeRepository.save(interviewee);
			log.info("To : " + update);
		}
		else
			throw new IntervieweeNotFoundException("Resource " + interviewee.getId() + " not fond for updatation");
	}
	
	
	
	
}
