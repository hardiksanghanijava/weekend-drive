package  com.weekend.drive.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InterviewerNotFoundException extends RuntimeException {
	
	public InterviewerNotFoundException(String message) {
		super(message);
	}

}
