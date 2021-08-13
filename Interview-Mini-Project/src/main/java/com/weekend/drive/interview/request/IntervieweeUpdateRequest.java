package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Interviewee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntervieweeUpdateRequest {
	
	private int id;
	private String name;
	private String skills;
	private String experience;
	private String qualification;


	public static Interviewee toIntervieweeRequestEnttity(IntervieweeUpdateRequest intervieweeUpdateRequest) throws IllegalAccessException, InvocationTargetException {
		Interviewee interviewee = new Interviewee();
		BeanUtils.copyProperties(interviewee, intervieweeUpdateRequest);
		return interviewee;
	}
	
	
}
