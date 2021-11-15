package ro.itschool.curs.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import ro.itschool.curs.dao.HotelDao;
import ro.itschool.curs.entity.Hotel;
import ro.itschool.curs.enums.Facilities;

public class HotelService {

    public HotelDao hotelDao;

	public HotelService() {
		super();
		this.hotelDao = new HotelDao();
	}
	public void saveHotel(Hotel hotel) {
		hotelDao.openCurrentSessionwithTransaction();
		hotelDao.persist(hotel);
		hotelDao.closeCurrentSessionwithTransaction();
		
	}

	public void updateHotel(Hotel hotel) {
		hotelDao.openCurrentSessionwithTransaction();
		hotelDao.update(hotel);
		hotelDao.closeCurrentSessionwithTransaction();
	}
	public Hotel findHotelById(int id) {	
		hotelDao.openCurrentSession();
		//cum returnam rezultatul daca inchidem sesiunea. daca nu salvam hotelul in sesiune nu mai avem acces la el
		//atribuim un film deja existent
		Hotel hotel = hotelDao.findById(id);
		hotelDao.closeCurrentSession();
		return hotel; // dupa return nu mai putem face nimic
	}
	


	
	public void hotel(Hotel hotel) {
		hotelDao.openCurrentSessionwithTransaction();
		hotelDao.delete(hotel);
		hotelDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Hotel> findAllHotels() {
		hotelDao.openCurrentSession();
		List<Hotel> lista = hotelDao.findAll();
		hotelDao.closeCurrentSession();
		return lista;
	}
	public void deleteAllHotels() {
		hotelDao.openCurrentSessionwithTransaction();
		hotelDao.deleteAll();
		hotelDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Hotel> findHotel() {
		hotelDao.openCurrentSession();
		List<Hotel> hotels = hotelDao.findHotel();
		hotelDao.closeCurrentSession();
		return hotels;
}
	public List<Hotel> findHotelByCapacity() {
		hotelDao.openCurrentSession();
		List<Hotel> hotels = hotelDao.findHotelByCapacity();
		hotelDao.closeCurrentSession();
		return hotels;
	}
	public List<Hotel> getAllHotels() {
		hotelDao.openCurrentSession();
		List<Hotel> hotel = hotelDao.getAllHotels();
		hotelDao.closeCurrentSession();
		return hotel;
	}
}