package com.avd.mapper;

import com.avd.entity.Room;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomMapper implements RowMapper<Room> {

    public Room mapRow(ResultSet resultSet, int i) throws SQLException {
        Room room = new Room();
        room.setRoom_no(  resultSet.getInt("room_no")   );
        room.setCategory( resultSet.getString("room_type")   );
        room.setRoomPrice(resultSet.getDouble("price") );
        return room;
    }
}
