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
@Table( name = "Customer")

@Data
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private int age;
	
	@Column
	private String gender;
	
	@ManyToMany(mappedBy = "customer")
	private Set<Room> room = new HashSet<>();
	
	public Customer(String firstName,  String lastName, int age, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;

	}

	public String toString() {
		return "\n Customer  [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age= " + age + ", gender=" + gender + "] \n";
	}
}
