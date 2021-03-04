package ticketbooking.ticketbookingservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PassengerDetail {
	@Id
	private Long id;
	private Integer ticketId;
	private String name;
	private Integer age;
	private Integer seatNo;
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}
	
	
	
	
}
