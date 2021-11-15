package ro.itschool.curs.service;

import java.util.List;

import ro.itschool.curs.dao.RoomDao;
import ro.itschool.curs.entity.Room;

public class RoomService {
	private RoomDao roomDao;

	public RoomService() {
		super();
		this.roomDao = new RoomDao();
	}
	public void saveRoom(Room room) {
		roomDao.openCurrentSessionwithTransaction();
		roomDao.persist(room);
		roomDao.closeCurrentSessionwithTransaction();
		
	}

	public void updateRoom(Room room) {
		roomDao.openCurrentSessionwithTransaction();
		roomDao.update(room);
		roomDao.closeCurrentSessionwithTransaction();
	}
	public Room findRoomById(int id) {	
		roomDao.openCurrentSession();
		//cum returnam rezultatul daca inchidem sesiunea. daca nu salvam filmul in sesiune nu mai avem acces la el
		//atribuim un film deja existent
		Room room = roomDao.findById(id);
		roomDao.closeCurrentSession();
		return room; // dupa return nu mai putem face nimic
	}
	
	public void room(Room room) {
		roomDao.openCurrentSessionwithTransaction();
		roomDao.delete(room);
		roomDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Room> findAllRooms() {
		roomDao.openCurrentSession();
		List<Room> lista = roomDao.findAll();
		roomDao.closeCurrentSession();
		return lista;
	}
	public void deleteAllRooms() {
		roomDao.openCurrentSessionwithTransaction();
		roomDao.deleteAll();
		roomDao.closeCurrentSessionwithTransaction();
	
	}
	
	
	
}


