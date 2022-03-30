package centerpark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class VehiculeException extends RuntimeException {

	public VehiculeException() {

	}

	public VehiculeException(String message) {
		super(message);
	}
}
