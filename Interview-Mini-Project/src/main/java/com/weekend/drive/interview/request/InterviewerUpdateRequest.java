package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Interviewer;

import lombok.Data;

@Data
public class InterviewerUpdateRequest {

	private int id;
	private String name;
		
	

	public static Interviewer toInterviewerRequestEnttity(InterviewerUpdateRequest interviewerRequest) throws IllegalAccessException, InvocationTargetException {
		Interviewer interviewer = new Interviewer();
		BeanUtils.copyProperties(interviewer, interviewerRequest);
		return interviewer;
	}
	
	
}
