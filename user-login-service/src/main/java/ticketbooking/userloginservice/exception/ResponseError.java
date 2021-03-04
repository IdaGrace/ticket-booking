package ticketbooking.userloginservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResponseError {

	private String message;
	private int statusCode;

	public ResponseError() {

	}

	public ResponseError(String message, int statusCode) {
		this.message = message;
		this.statusCode = statusCode;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
