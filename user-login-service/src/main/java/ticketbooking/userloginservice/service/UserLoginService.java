package ticketbooking.userloginservice.service;

import ticketbooking.userloginservice.dto.TicketBookingDto;
import ticketbooking.userloginservice.dto.TicketBookingResDto;
import ticketbooking.userloginservice.entity.UserLogin;

public interface UserLoginService {

	public UserLogin userLoginMethod(String userName,String password);
	
	public TicketBookingResDto booking(TicketBookingDto dto);
	
	public TicketBookingResDto lastRecord(String userId);
}
