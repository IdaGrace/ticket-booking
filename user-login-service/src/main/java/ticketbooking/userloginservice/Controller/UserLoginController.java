package ticketbooking.userloginservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ticketbooking.userloginservice.dto.TicketBookingResDto;
import ticketbooking.userloginservice.dto.UserLoginReqDto;
import ticketbooking.userloginservice.entity.UserLogin;
//import ticketbooking.userloginservice.repository.UserLoginRepository;
import ticketbooking.userloginservice.service.UserLoginService;

@RestController
@RequestMapping("/userlogin")
public class UserLoginController {
	
	@Autowired
	UserLoginService userLoginService;

	@PostMapping("/users")
	public UserLogin userLoginMethod(@RequestBody UserLoginReqDto dto) {
		
		
	return userLoginService.userLoginMethod(dto.getUserName(),dto.getPassword());
		
		//return null;
	}
	
	
	@PostMapping("/create")
	public TicketBookingResDto createTicket(@RequestBody ticketbooking.userloginservice.dto.TicketBookingDto dto) throws Exception {
		
		TicketBookingResDto tktbookObj =userLoginService.booking(dto);
		return tktbookObj;
		
	}
	
	
	@GetMapping("/lastRecord/{userId}")
	public TicketBookingResDto info(@PathVariable String userId)  {
		
		TicketBookingResDto tktbookObj =userLoginService.lastRecord(userId);
		return tktbookObj;
		
	}
}

