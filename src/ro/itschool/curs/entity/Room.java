package ro.itschool.curs.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.itschool.curs.enums.Facilities;
import ro.itschool.curs.enums.ServicesType;

@Entity
@Table(name = "Room")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String type;
	
	@Column
	private int number;
	
	@Column
	private double price;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Hotel hotel;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "customer_room", joinColumns = { @JoinColumn(name = "room_id") }, inverseJoinColumns = {
			@JoinColumn(name = "customer_id") })
	private Set<Customer> customer = new HashSet<>();
	
	public Room(String type, int number, Set<Customer> customer, double price, Hotel hotel) {
		super();
		this.type = type;
		this.number = number;
		this.price = price;
		this.hotel = hotel;
	
	}

	@Override
	public String toString() {
		String finalString;
		finalString = "Room: id=" + id + ", type=" + type + ", number=" + number + ", price= " + price + "\n";
				if (Hibernate.isInitialized(this.customer))
					finalString += this.customer.toString();
				if (Hibernate.isInitialized(this.hotel))
				finalString += this.hotel.toString();
		return finalString;
	}

}
