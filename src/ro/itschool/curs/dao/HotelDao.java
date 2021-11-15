package ro.itschool.curs.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Collection;


import lombok.extern.java.Log;

import ro.itschool.curs.entity.Hotel;
import ro.itschool.curs.enums.Facilities;
import ro.itschool.curs.util.HibernateUtils;


@Log

public class HotelDao implements EntityDao<Hotel, Integer> {

	private Session session;

	private Transaction transaction;

	public HotelDao() {
		
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
	public void persist(Hotel hotel) {
		session.save(hotel);
		
	}

	@Override
	public void update(Hotel entity) {
		session.update(entity);
		
	}

	@Override
	public Hotel findById(Integer id) {
		log.info("Am apelat metoda findById");
		return session.get(Hotel.class, id);
		
	}
	

	@Override
	public void delete(Hotel entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);
		
	}

	@Override
	public List<Hotel> findAll() {
		log.info("Am apelat metoda findAll");
		return session.createQuery("from Hotel").list();

	}

	@Override
	public void deleteAll() {
	log.info("Am apelat metoda deleteAll");
		session.createQuery("delete from Hotel").executeUpdate();
		
	}

	public List<Hotel> findHotelByCapacity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter what type of capacity  you want: ");
		String capacity= scanner.next();
		log.info("Am apelat metoda find by capacity");
		List<Hotel> hotels = session.createQuery("from Hotel").list();
		List<Hotel> filteredHotels = new ArrayList<>();
		for (Hotel hotel : hotels) {
			if (hotel.toString().contains(capacity))
				filteredHotels.add(hotel);
		}
		return filteredHotels;
	}
	

	public List<Hotel> findHotel() {
		log.info("Am apelat metoda find hotel");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter what location you want: ");
     	String location= scanner.next();
		System.out.println("Enter what facilities you want: ");
		String facilities = String.valueOf(scanner.next().toUpperCase());
		System.out.println("Enter what services you want: ");
		String services_type = String.valueOf(scanner.next().toUpperCase());
		List<Hotel> hotels = session.createQuery("from Hotel").list();
		List<Hotel> filteredHotels = new ArrayList<>();
		for (Hotel hotel : hotels) {
			if (hotel.toString().contains(location) && hotel.toString().contains(facilities) && hotel.toString().contains(services_type))filteredHotels.add(hotel);
		
	}
		return filteredHotels;
}
	@Transactional
	public List<Hotel> getAllHotels() {
		String hql = "FROM Hotel h ORDER BY h.name";
		Query query = session.createQuery(hql);
		List<Hotel> hotel = query.getResultList();
		return hotel;
	}
}
   