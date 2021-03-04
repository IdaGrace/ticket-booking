package ticketbooking.ticketbookingservice.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ticketbooking.ticketbookingservice.dto.TicketBookingDto;
import ticketbooking.ticketbookingservice.entity.Route;
import ticketbooking.ticketbookingservice.entity.TicketBooking;
import ticketbooking.ticketbookingservice.exception.TicketbookingException;
import ticketbooking.ticketbookingservice.repository.RouteRepository;
import ticketbooking.ticketbookingservice.repository.TicketBookingRepository;
import ticketbooking.ticketbookingservice.service.TicketbookingService;
@Service

@Transactional
public class TicketBookingServiceImpl implements TicketbookingService{
	
	@Autowired
	RouteRepository routeRepository;
	
	@Autowired
	TicketBookingRepository ticketBookingRepository;
	
	@Autowired
	Environment envronment;
	@Transactional()
	public TicketBooking booking(TicketBookingDto dto) throws Exception {
		
		System.out.println(" Travel date "+dto.getTravelDate());
		System.out.println("Port no "+envronment.getProperty("local.server.port") );
		
		Optional<Route> route=routeRepository.findByTrainNoAndDate(dto.getTrainNo(),dto.getTravelDate());
		
		if(!route.isPresent()) {
			System.out.println("invalid train no or train is unavailable for the given date");
			throw new TicketbookingException("invalid train no or train is unavailable for the given date");
			
		}else if(dto.getNoOfPerson()>route.get().getTicketavailability()) {
			System.out.println("available seat is only "+route.get().getTicketavailability());
			throw new TicketbookingException("available seat is only "+route.get().getTicketavailability());
			
		}else if(dto.getTotalFare()<(route.get().getFare()*dto.getNoOfPerson())) {
				System.out.println("Insufficient amount");
				throw new TicketbookingException("Insufficient amount");
			}else {
				TicketBooking ticketBooking = new TicketBooking();
				
				Route route1=route.get();
				
				//ticketBooking.setTicketId(1);
				ticketBooking.setTrainNo(dto.getTrainNo());
				ticketBooking.setNoOfPerson(dto.getNoOfPerson());
				ticketBooking.setTotalFare(dto.getTotalFare());
				ticketBooking.setUserId(dto.getUserId());
				ticketBooking.setSource(route.get().getSource());
				ticketBooking.setDestination(route.get().getDestination());
				
				ticketBooking.setTravelDate(dto.getTravelDate());
				
				route1.setTicketavailability(route1.getTicketavailability()-dto.getNoOfPerson());
				
				
				routeRepository.save(route1);
				//if(dto.getNoOfPerson()==2)
				//throw new Exception();
				return ticketBookingRepository.save(ticketBooking);
				
				
				
				
			
				
			}
			
		
		
		//return null;
	}

	public TicketBooking lastRecord(Integer userId) {
		
	Optional<TicketBooking> tb=	ticketBookingRepository.findByTicketId(	ticketBookingRepository.findMaxId(userId));
		return tb.get();
	}


}
