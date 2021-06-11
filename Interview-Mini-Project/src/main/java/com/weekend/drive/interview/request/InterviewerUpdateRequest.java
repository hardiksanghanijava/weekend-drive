package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Interviewer;

public class InterviewerUpdateRequest {

	private int id;
	private String name;
		
	public InterviewerUpdateRequest() {
		super();
	}

	public InterviewerUpdateRequest(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Interviewer toInterviewerRequestEnttity(InterviewerUpdateRequest interviewerRequest) throws IllegalAccessException, InvocationTargetException {
		Interviewer interviewer = new Interviewer();
		BeanUtils.copyProperties(interviewer, interviewerRequest);
		return interviewer;
	}
	
	
}
