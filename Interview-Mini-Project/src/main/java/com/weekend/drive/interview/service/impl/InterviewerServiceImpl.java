package com.weekend.drive.interview.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekend.drive.interview.bean.Interviewer;
import com.weekend.drive.interview.bean.ScheduleInterviewDto;
import com.weekend.drive.interview.exception.InterviewAlreadyScheduled;
import com.weekend.drive.interview.exception.InterviewerNotFoundException;
import com.weekend.drive.interview.repository.InterviewerRepository;
import com.weekend.drive.interview.request.InterviewerCreateRequest;
import com.weekend.drive.interview.request.InterviewerUpdateRequest;
import com.weekend.drive.interview.response.InterviewerResponse;
import com.weekend.drive.interview.service.InterviewerService;

@Service
public class InterviewerServiceImpl implements InterviewerService {

Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private InterviewerRepository interviewerRepository;
	
	@Autowired
	private ScheduleInterviewService scheduleInterviewService;
	
	//Retrieve all interviewer
	public List<InterviewerResponse> getAllInterviewer(){
		//Original Entity List
		List<Interviewer> interviewers = interviewerRepository.findAll();
		
		//Response List
		List<InterviewerResponse> interviewerResponse = new ArrayList<>();
		
		//Iterating original to response
		interviewers.stream().forEach(interviewer -> { 
			try {
				interviewerResponse.add(Interviewer.toInterviewerEntityResponse(interviewer));
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		});
		
		logger.info("All Retieved Records : " + interviewerResponse);
		
		//Returning the response
		return interviewerResponse;
	}
	
	//Retrieve interviewer by id
	public InterviewerResponse getInterviewerById(int id) throws IllegalAccessException, InvocationTargetException{
		//Getting original interviewer by id
		Interviewer interviewer = interviewerRepository.findById(id).get();
		
		//Condition for interviewer exist or not
		if(interviewer==null)
			throw new InterviewerNotFoundException("Interviewer " + id + " Not Foud");
		
		//Coping original to response
		InterviewerResponse interviewerResponse = Interviewer.toInterviewerEntityResponse(interviewer);
		logger.info("Find record by id : " + interviewerResponse);
		
		//Returning the response
		return interviewerResponse;
	}
	
	//Create new interviewer
	public Interviewer createInterviewer(InterviewerCreateRequest interviewerCreateRequest) throws IllegalAccessException, InvocationTargetException {
		//Creating the interviewer from request to entity
		Interviewer interviewer = interviewerRepository.save(InterviewerCreateRequest.toInterviewerRequestEnttity(interviewerCreateRequest));
		logger.info("Created Resource : " + interviewer);
		
		//Returning the created interviewer back
		return interviewer;
	}
	
	//Delete interviewer by id
	public void deleteInterviewer(int id) throws IllegalAccessException, InvocationTargetException {
		//Fetch interviewer if exist
		getInterviewerById(id);
		
		//Fetch all scheduled interviews
		List<ScheduleInterviewDto> scheduleInterview = scheduleInterviewService.getAllScheduleInterviewDto();
		
		//Stream api loop for checking foreign keys
		scheduleInterview.stream().forEach(scheduleInterview2 -> 
		{if(scheduleInterview2.getInterviewerId()==id) {
			throw new InterviewAlreadyScheduled("Sorry you can't delete this interviewer, It's already scheduled");
		}}); 
		
		//deleting the interviewer
		interviewerRepository.deleteById(id);
	}
	
	//Update existing interviewer
	public Interviewer updateInterviewer(InterviewerUpdateRequest interviewerUpdateRequest) throws IllegalAccessException, InvocationTargetException {
		//Fetch interviewer if exist
		getInterviewerById(interviewerUpdateRequest.getId());
		
		//Updating the interviewer from UpdateRequest
		Interviewer interviewer = interviewerRepository.save(InterviewerUpdateRequest.toInterviewerRequestEnttity(interviewerUpdateRequest));
		logger.info("Interviewer Updated : " + interviewer);
		
		//Returning the updated interviewer back 
		return interviewer;
	}
	
}
