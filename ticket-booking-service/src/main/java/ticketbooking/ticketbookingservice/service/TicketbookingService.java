package ticketbooking.ticketbookingservice.service;

import ticketbooking.ticketbookingservice.dto.TicketBookingDto;
import ticketbooking.ticketbookingservice.entity.TicketBooking;

public interface TicketbookingService {

	public TicketBooking booking(TicketBookingDto dto) throws Exception;
	
	public TicketBooking lastRecord(Integer userId);
}
