package com.example.Hotel_Management.Repo;

import com.example.Hotel_Management.Model.Room;
import com.example.Hotel_Management.Model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends CrudRepository<Room,Integer> {

    List<Room> findByRoomPrice(double price);


    List<Room> findByRoomPriceLessThanEqualAndRoomAvailable(double price, boolean b);

    List<Room> findByRoomPriceLessThanEqualOrRoomAvailable(double price, boolean b);

    List<Room> findByRoomTypeOrRoomAvailableOrderByRoomPrice(Type type, boolean b);
}
