package ro.itschool.curs.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.itschool.curs.enums.Facilities;
import ro.itschool.curs.enums.ServicesType;


@Entity
@Table(name = "Hotel")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column(nullable = false)
	private String location;
	
	@Column
	private int numberOfRooms;
	
	@Column
	private int numberOfStars;
	
	@Column
	private String capacity;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "services_type")
	private ServicesType servicesType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "facilities")
	private Facilities facilities;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "hotel")
	private List<Room> room;

	
	public Hotel(String name, String location, int numberOfRooms, int numberOfStars, String capacity, ServicesType servicesType, Facilities facilities) {
		super();
		this.name = name;
		this.location = location;
		this.numberOfRooms = numberOfRooms;
		this.numberOfStars = numberOfStars;
		this.capacity = capacity;
		this.servicesType = servicesType;
		this.facilities = facilities;
	}

	@Override
	public String toString() {
		return "\n Hotel [id=" + id + ", name=" + name + ", location=" + location + ", numberOfRooms=" + numberOfRooms + ", numberOfStars="
				+ numberOfStars + ", capacity=" + capacity + ", servicesType= " + servicesType + ", facilities = " + facilities + "] \n";
	}

}
