package ro.itschool.curs.service;

import java.text.ParseException;
import java.util.List;

import ro.itschool.curs.dao.BookingDao;
import ro.itschool.curs.entity.Booking;


public class BookingService {

	private BookingDao bookingDao;

	public BookingService() {
		super();
		this.bookingDao = new BookingDao();
	}
	public void saveBooking(Booking booking) {
		bookingDao.openCurrentSessionwithTransaction();
		bookingDao.persist(booking);
		bookingDao.closeCurrentSessionwithTransaction();
		
	}

	public void updateBooking(Booking booking) {
		bookingDao.openCurrentSessionwithTransaction();
		bookingDao.update(booking);
		bookingDao.closeCurrentSessionwithTransaction();
	}
	public Booking findBookingById(int id) {	
		bookingDao.openCurrentSession();
		//cum returnam rezultatul daca inchidem sesiunea. daca nu salvam filmul in sesiune nu mai avem acces la el
		//atribuim un film deja existent
		Booking booking = bookingDao.findById(id);
		bookingDao.closeCurrentSession();
		return booking; // dupa return nu mai putem face nimic
	}
	
		
	public void booking(Booking booking) {
		bookingDao.openCurrentSessionwithTransaction();
		bookingDao.delete(booking);
		bookingDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Booking> findAllBooking() {
		bookingDao.openCurrentSession();
		List<Booking> lista = bookingDao.findAll();
		bookingDao.closeCurrentSession();
		return lista;
	}
	public void deleteAllBooking() {
		bookingDao.openCurrentSessionwithTransaction();
		bookingDao.deleteAll();
		bookingDao.closeCurrentSessionwithTransaction();
	}
	public void createBooking() {
		bookingDao.openCurrentSessionwithTransaction();
		bookingDao.createBooking();
		bookingDao.closeCurrentSessionwithTransaction();
}
	
}
