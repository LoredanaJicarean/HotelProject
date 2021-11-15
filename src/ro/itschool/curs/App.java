package ro.itschool.curs;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ro.itschool.curs.dao.HotelDao;
import ro.itschool.curs.entity.Booking;
import ro.itschool.curs.entity.Customer;
import ro.itschool.curs.entity.Hotel;
import ro.itschool.curs.entity.Room;
import ro.itschool.curs.enums.Facilities;
import ro.itschool.curs.service.BookingService;
import ro.itschool.curs.service.CustomerService;
import ro.itschool.curs.service.HotelService;
import ro.itschool.curs.service.RoomService;
import ro.itschool.curs.util.HibernateUtils;

public class App {

	public static void main(String[] args) {

CustomerService customerService = new CustomerService();
Customer customer = new Customer();
customerService.createCustomer();
		BookingService bookingService = new BookingService();
		bookingService.createBooking();
		HotelService hotelService = new HotelService();
   	System.out.println(hotelService.findHotel());
System.out.println(hotelService.findHotelByCapacity());
  System.out.println(customerService.getAllCustomers());
    HashMap<String, Integer> customerNameAge = new HashMap<String, Integer>();
	    customerNameAge.put("Horatiu Pop", 26);
	    customerNameAge.put("Andreea Pop", 25);
	    customerNameAge.put("David Stancu", 35);
	    customerNameAge.put("Stefania Onciu", 19);
	    customerNameAge.put("Andrei Stefanescu", 40);
	    customerNameAge.put("Sebastian Olar", 22);
	    customerNameAge.put("Sofia Codrin", 32);
	    customerNameAge.put("Katia Popescu", 28);
	    customerNameAge.put("DianaBacaian", 27);
	    System.out.println(customerNameAge);
	}
}
