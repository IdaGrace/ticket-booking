package ticketbooking.ticketbookingservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Route {
	
	@Id
	private Integer trainNo;
	private Date date;
	private String source;
	private String destination;
	private double fare;
	private int ticketavailability;
	private int totalnoticket;
	
	
	
	
	public Integer getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(Integer trainNo) {
		this.trainNo = trainNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public int getTicketavailability() {
		return ticketavailability;
	}
	public void setTicketavailability(int ticketavailability) {
		this.ticketavailability = ticketavailability;
	}
	public int getTotalnoticket() {
		return totalnoticket;
	}
	public void setTotalnoticket(int totalnoticket) {
		this.totalnoticket = totalnoticket;
	}
	
	
	

}
