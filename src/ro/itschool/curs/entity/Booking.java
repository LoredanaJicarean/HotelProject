package ro.itschool.curs.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.itschool.curs.enums.Facilities;
import ro.itschool.curs.enums.RoomType;
import ro.itschool.curs.enums.ServicesType;

@Entity
@Table(name= "Booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private int numberOfPerson;
	@Column
	private int numberOfDays;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Enumerated(EnumType.STRING)
	@Column(name = "room_type")
	private RoomType roomType;
	@Column
	private double price;
	
	public Booking(int numberOfPerson, int numberOfDays, Date startDate, Date endDate, RoomType roomType, double price) {
		super();
		this.numberOfPerson = numberOfPerson;
		this.numberOfDays = numberOfDays;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomType = roomType;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "\n Booking [id= " + id + ", numberOfPersone= " + numberOfPerson + ", numberOfDays= " + numberOfDays + ", startDate= " + startDate + ", endDate=" + endDate + ", roomType= " + roomType + ", price= " + price + "] \n";
	}

	


}
	
