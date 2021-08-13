package com.weekend.drive.interview.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.weekend.drive.interview.bean.Interviewer;
import com.weekend.drive.interview.request.InterviewerCreateRequest;
import com.weekend.drive.interview.request.InterviewerUpdateRequest;
import com.weekend.drive.interview.response.InterviewerResponse;

public interface InterviewerService {
	
	public List<InterviewerResponse> getAllInterviewer();
	
	//Retrieve interviewer by id
	public InterviewerResponse getInterviewerById(int id) throws IllegalAccessException, InvocationTargetException;
	
	//Create new interviewer
	public Interviewer createInterviewer(InterviewerCreateRequest interviewerCreateRequest) throws IllegalAccessException, InvocationTargetException;
	//Delete interviewer by id
	public void deleteInterviewer(int id) throws IllegalAccessException, InvocationTargetException;
	//Update existing interviewer
	public Interviewer updateInterviewer(InterviewerUpdateRequest interviewerUpdateRequest) throws IllegalAccessException, InvocationTargetException;
	

}
