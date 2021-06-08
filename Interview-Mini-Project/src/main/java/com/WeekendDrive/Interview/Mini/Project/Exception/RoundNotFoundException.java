package com.WeekendDrive.Interview.Mini.Project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoundNotFoundException extends RuntimeException {

	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoundNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	

}
