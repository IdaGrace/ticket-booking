package ticketbooking.ticketbookingservice.exception;

import java.io.Serializable;


public class TicketbookingException extends RuntimeException implements Serializable{


	private static final long serialVersionUID = 1L;

	public TicketbookingException(String message) {
		super(message);
	}


}



