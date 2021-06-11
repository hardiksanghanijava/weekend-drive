package  com.weekend.drive.interview.mini.project.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InterviewAlreadyScheduled extends RuntimeException {
	
	public InterviewAlreadyScheduled(String message) {
		super(message);
	}


}
