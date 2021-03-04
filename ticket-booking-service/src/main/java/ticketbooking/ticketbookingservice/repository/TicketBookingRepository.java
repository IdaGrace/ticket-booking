package ticketbooking.ticketbookingservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ticketbooking.ticketbookingservice.entity.TicketBooking;

public interface TicketBookingRepository extends JpaRepository<TicketBooking,Integer>{
	
	@Query("select Max(t.ticketId) from TicketBooking t where t.userId=?1")
	public Integer findMaxId(Integer userId);
	
	public Optional<TicketBooking> findByTicketId(Integer ticketId);

}
