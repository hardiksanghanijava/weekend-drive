package  com.weekend.drive.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class PositionsNotFoundException extends RuntimeException {
	public PositionsNotFoundException(String message) {
		super(message);
	}
}
