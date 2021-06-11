package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Interviewer;

public class InterviewerCreateRequest {

	
	
	public InterviewerCreateRequest() {
		super();
	}

	public InterviewerCreateRequest(String name) {
		super();
		this.name = name;
	}



	private String name;
	
		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public static Interviewer toInterviewerRequestEnttity(InterviewerCreateRequest interviewerRequest) throws IllegalAccessException, InvocationTargetException {
		Interviewer interviewer = new Interviewer();
		BeanUtils.copyProperties(interviewer, interviewerRequest);
		return interviewer;
	}
	
	
}
