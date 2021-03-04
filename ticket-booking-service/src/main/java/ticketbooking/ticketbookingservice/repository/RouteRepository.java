package ticketbooking.ticketbookingservice.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ticketbooking.ticketbookingservice.entity.Route;

public interface RouteRepository extends JpaRepository<Route,Integer>{
	
	public Optional<Route> findByTrainNoAndDate(Integer trainNo,Date date);

}
