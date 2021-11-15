package ro.itschool.curs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.curs.entity.Room;
import ro.itschool.curs.util.HibernateUtils;

@Log
public class RoomDao implements EntityDao<Room, Integer> {
	private Session session;

	private Transaction transaction;

	public RoomDao() {
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
	public void persist(Room entity) {
		session.save(entity);
	}

	@Override
	public void update(Room entity) {
		session.update(entity);

	}

	@Override
	public Room findById(Integer id) {
	log.info("Am apelat metoda findById");
		return session.get(Room.class, id);
	}
	
	public List<Room> findRoomByType(String type) {
		log.info("Am apelat metoda find by name");
		List<Room> rooms = session.createQuery("from Room").list();
		List<Room> filteredRooms = new ArrayList<>();
		for (Room room : rooms) {
			if (room.getType().contains(type))
				filteredRooms.add(room);
		}
		return filteredRooms;
	}
	@Override
	public void delete(Room entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);

	}

	@Override
	public List<Room> findAll() {
		log.info("Am apelat metoda findAll");
		return session.createQuery("from Room").list();
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda deleteAll");
		session.createQuery("delete from Room").executeUpdate();

	
	}


}
