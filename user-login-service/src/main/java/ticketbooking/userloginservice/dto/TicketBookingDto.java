package ticketbooking.userloginservice.dto;

import java.util.Date;

public class TicketBookingDto {

	private Integer trainNo;
	
	private Integer userId;
	
	private Date travelDate;
	
	private Integer noOfPerson;
	
	private Double totalFare;
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(Integer trainNo) {
		this.trainNo = trainNo;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Integer getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(Integer noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}
	
	
	
}
