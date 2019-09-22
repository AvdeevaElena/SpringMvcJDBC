package com.avd.mapper;

import com.avd.entity.Room;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomMapperAll  implements RowMapper<Room> {

    public Room mapRow(ResultSet resultSet, int i) throws SQLException {
        Room room = new Room();
        room.setId(resultSet.getInt("id"));
        room.setStatus(resultSet.getString("status"));

        return room;
    }
}