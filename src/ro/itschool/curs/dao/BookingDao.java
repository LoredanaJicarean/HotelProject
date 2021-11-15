package ro.itschool.curs.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.curs.entity.Booking;
import ro.itschool.curs.entity.Customer;
import ro.itschool.curs.enums.RoomType;
import ro.itschool.curs.service.BookingService;
import ro.itschool.curs.service.HotelService;
import ro.itschool.curs.util.HibernateUtils;

@Log

public class BookingDao implements EntityDao<Booking, Integer> {

	private Session session;

	private Transaction transaction;

	public BookingDao() {
	}

	public Session openCurrentSession() {
		session = HibernateUtils.getSessionFactory().openSession();
		return session;
	}

	public Session openCurrentSessionwithTransaction() {
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public void closeCurrentSession() {
		session.close();
	}

	public void closeCurrentSessionwithTransaction() {
		transaction.commit();
		session.close();
	}

	@Override
	public void persist(Booking entity) {
		session.save(entity);

	}

	@Override
	public void update(Booking entity) {
		session.update(entity);

	}

	@Override
	public Booking findById(Integer id) {
		log.info("Am apelat metoda findById");
		return session.get(Booking.class, id);

	}

	@Override
	public void delete(Booking entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);

	}

	@Override
	public List<Booking> findAll() {
		log.info("Am apelat metoda findAll");
		return session.createQuery("from Booking").list();

	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda deleteAll");
		session.createQuery("delete from Booking").executeUpdate();
	}

	public void createBooking() {
		Booking booking = new Booking();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of people: ");
		int numberOfPerson = scanner.nextInt();
		System.out.print("Enter the check-in date in format DD-MM-YYYY: ");
		String startDate = scanner.next();
		System.out.println("Enter the cehck-out date in format DD-MM-YYYY: ");
		String endDate = scanner.next();
		System.out.print("Enter the type of the room");
		String roomType = scanner.next();

	
	}

}
