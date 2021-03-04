package ticketbooking.ticketbookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ticketbooking.ticketbookingservice.dto.TicketBookingDto;
import ticketbooking.ticketbookingservice.entity.TicketBooking;
import ticketbooking.ticketbookingservice.service.TicketbookingService;

@RestController
public class TicketBookingController {
	
	
	@Autowired
	TicketbookingService ticketbookingService;
	
	@PostMapping("/create")
	public TicketBooking createTicket(@RequestBody TicketBookingDto dto) throws Exception {
		
		TicketBooking tktbookObj =ticketbookingService.booking(dto);
		return tktbookObj;
		
	}
	
	@GetMapping("/lastRecord/{userId}")
	public TicketBooking lastRecord(@PathVariable String userId) {
		
	return	ticketbookingService.lastRecord(Integer.parseInt(userId));
	}
}
