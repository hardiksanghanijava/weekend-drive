package com.weekend.drive.interview.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekend.drive.interview.bean.Interviewee;
import com.weekend.drive.interview.bean.ScheduleInterviewDto;
import com.weekend.drive.interview.exception.InterviewAlreadyScheduled;
import com.weekend.drive.interview.exception.IntervieweeNotFoundException;
import com.weekend.drive.interview.repository.IntervieweeRepository;
import com.weekend.drive.interview.request.IntervieweeCreateRequest;
import com.weekend.drive.interview.request.IntervieweeUpdateRequest;
import com.weekend.drive.interview.response.IntervieweeResponse;
import com.weekend.drive.interview.service.IntervieweeService;
import com.weekend.drive.interview.service.ScheduleInterviewService;

@Service
public class IntervieweeServiceImpl implements IntervieweeService{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IntervieweeRepository intervieweeRepository;
	
	@Autowired
	private ScheduleInterviewService scheduleInterviewService;
	
	//Retrieve all interviewee
	@Override
	public List<IntervieweeResponse> getAllInterviewee(){
		//Original Entity List
		List<Interviewee> interviewees = intervieweeRepository.findAll();
		
		//Response List
		List<IntervieweeResponse> intervieweeResponse = new ArrayList<>();
		
		//Iterating original to response
		interviewees.stream().forEach(interviewee -> { 
			try {
				intervieweeResponse.add(Interviewee.toIntervieweeEntityResponse(interviewee));
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		});
		
		logger.info("All Retieved Records : " + intervieweeResponse);
		
		//Returning the response
		return intervieweeResponse;
	}
	
	//Retrieve interviewee by id
	@Override
	public IntervieweeResponse getIntervieweeById(int id) throws IllegalAccessException, InvocationTargetException{
		//Getting original interviewee by id
		Interviewee interviewee = intervieweeRepository.findById(id).get();
		
		//Condition for interviewee exist or not
		if(interviewee==null)
			throw new IntervieweeNotFoundException("Interviewee " + id + " Not Foud");
		
		//Coping original to response
		IntervieweeResponse intervieweeResponse = Interviewee.toIntervieweeEntityResponse(interviewee);
		logger.info("Find record by id : " + intervieweeResponse);
		
		//Returning the response
		return intervieweeResponse;
	}
	
	//Create new interviewee
	@Override
	public Interviewee createInterviewee(IntervieweeCreateRequest intervieweeCreateRequest) throws IllegalAccessException, InvocationTargetException {
		//Creating the interviewee from request to entity
		Interviewee interviewee = intervieweeRepository.save(IntervieweeCreateRequest.toIntervieweeRequestEnttity(intervieweeCreateRequest));
		logger.info("Created Resource : " + interviewee);
		
		//Returning the created interviewee back
		return interviewee;
	}
	
	//Delete interviewee by id
	@Override
	public void deleteInterviewee(int id) throws IllegalAccessException, InvocationTargetException {
		//Fetch interviewee if exist
		getIntervieweeById(id);
		
		//Fetch all scheduled interviews
		List<ScheduleInterviewDto> scheduleInterview = scheduleInterviewService.getAllScheduleInterviewDto();
		
		//Stream api loop for checking foreign keys
		scheduleInterview.stream().forEach(scheduleInterview2 -> 
		{if(scheduleInterview2.getIntervieweeId()==id) {
			throw new InterviewAlreadyScheduled("Sorry you can't delete this interviewee, It's already scheduled");
		}}); 
		
		//deleting the interviewee
		intervieweeRepository.deleteById(id);
	}
	
	//Update existing interviewee
	@Override
	public Interviewee updateInterviewee(IntervieweeUpdateRequest intervieweeUpdateRequest) throws IllegalAccessException, InvocationTargetException {
		//Fetch interviewee if exist
		getIntervieweeById(intervieweeUpdateRequest.getId());
		
		//Updating the interviewee from UpdateRequest
		Interviewee interviewee = intervieweeRepository.save(IntervieweeUpdateRequest.toIntervieweeRequestEnttity(intervieweeUpdateRequest));
		logger.info("Interviewee Updated : " + interviewee);
		
		//Returning the updated interviewee back 
		return interviewee;
	}
	
	
	
	
}
