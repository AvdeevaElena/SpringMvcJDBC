package com.avd.dao.room;

import com.avd.entity.Room;

import java.util.List;

public interface RoomDao {
    List<Room> findAll();
    List<Room> findAllAvailableRooms(String checkIn, String checkOut);
}
