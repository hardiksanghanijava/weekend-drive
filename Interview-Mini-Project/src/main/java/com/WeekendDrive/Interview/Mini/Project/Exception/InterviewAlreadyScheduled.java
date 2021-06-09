package com.WeekendDrive.Interview.Mini.Project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InterviewAlreadyScheduled extends RuntimeException {
	
	public InterviewAlreadyScheduled(String message) {
		super(message);
	}


}
