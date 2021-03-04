package ticketbooking.userloginservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import ticketbooking.userloginservice.dto.TicketBookingResDto;

@FeignClient(name="http://ticket-booking")
public interface TicketBookingProxy {

	@PostMapping("/create")
	public TicketBookingResDto createTicket(@RequestBody ticketbooking.userloginservice.dto.TicketBookingDto dto);
	
	@GetMapping("/lastRecord/{userId}")
	public TicketBookingResDto lastRecord(@PathVariable("userId") String userId);

	//public TicketBookingResDto lastRecord(String userId);
}
