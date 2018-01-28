package bdd.mysql.repo;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import bdd.mysql.models.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
	@Transactional
	long deleteRoomById(long id);
	
	Room findRoomById(long id);
	Set<Room> findRoomByType(String type);
	//Set<Room> showAllRoomsWithPriceGreaterThanEqual(double price);
	
	Set<Room> findAll();
}
