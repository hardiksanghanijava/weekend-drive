package com.weekend.drive.interview.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.weekend.drive.interview.bean.Interviewee;
import com.weekend.drive.interview.request.IntervieweeCreateRequest;
import com.weekend.drive.interview.request.IntervieweeUpdateRequest;
import com.weekend.drive.interview.response.IntervieweeResponse;

public interface IntervieweeService {
	
	//Retrieve all interviewee
	public List<IntervieweeResponse> getAllInterviewee();
			
	//Retrieve interviewee by id
	public IntervieweeResponse getIntervieweeById(int id) throws IllegalAccessException, InvocationTargetException;
		
	//By Name
	public List<Interviewee> findByIntervieweeName(String name);
	
	//Create new interviewee
	public Interviewee createInterviewee(IntervieweeCreateRequest intervieweeCreateRequest) throws IllegalAccessException, InvocationTargetException;
		
	//Delete interviewee by id
	public void deleteInterviewee(int id) throws IllegalAccessException, InvocationTargetException;
		
	//Update existing interviewee
	public Interviewee updateInterviewee(IntervieweeUpdateRequest intervieweeUpdateRequest) throws IllegalAccessException, InvocationTargetException;
		
}
