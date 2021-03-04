package ticketbooking.userloginservice.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticketbooking.userloginservice.dto.TicketBookingDto;
import ticketbooking.userloginservice.dto.TicketBookingResDto;
import ticketbooking.userloginservice.entity.UserLogin;
import ticketbooking.userloginservice.exception.UserNotFoundException;
import ticketbooking.userloginservice.proxy.TicketBookingProxy;
import ticketbooking.userloginservice.repository.UserLoginRepository;
import ticketbooking.userloginservice.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Autowired
	TicketBookingProxy ticketBookingProxy;
	
	public UserLogin userLoginMethod(String userName,String password) {
		
	Optional<UserLogin> user=	userLoginRepository.findByUserNameAndPassword(userName, password);
		
	
	if(!user.isPresent()) {
		throw new UserNotFoundException("User Not Found");
		
	}
		return user.get();
		
	}
	
	
	public TicketBookingResDto booking(TicketBookingDto dto) {
		
		TicketBookingResDto ticketBookingResDto	= ticketBookingProxy.createTicket(dto);
		
		System.out.println(ticketBookingResDto.getSource());
		System.out.println(ticketBookingResDto.getDestination());
		
		return ticketBookingResDto;
	}

	
	public TicketBookingResDto lastRecord(String userId) {
TicketBookingResDto ticketBookingResDto	= ticketBookingProxy.lastRecord(userId);
		
		System.out.println(ticketBookingResDto.getSource());
		System.out.println(ticketBookingResDto.getDestination());
		
		return ticketBookingResDto;
		
	}
}
