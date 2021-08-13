package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Interviewer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterviewerCreateRequest {

	private String name;
	

	public static Interviewer toInterviewerRequestEnttity(InterviewerCreateRequest interviewerRequest) throws IllegalAccessException, InvocationTargetException {
		Interviewer interviewer = new Interviewer();
		BeanUtils.copyProperties(interviewer, interviewerRequest);
		return interviewer;
	}
	
	
}
