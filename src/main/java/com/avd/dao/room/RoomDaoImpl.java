package com.avd.dao.room;

import com.avd.entity.Room;
import com.avd.mapper.RoomMapper;
import com.avd.mapper.RoomMapperAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RoomDaoImpl implements RoomDao {


    @Autowired
    public final JdbcTemplate jdbcTemplate;


    public RoomDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Room> findAll() {
        String sql = "SELECT * FROM rooms";
        return jdbcTemplate.query(sql, new RoomMapperAll());
    }


    public  List<Room> findAllAvailableRooms(String checkIn, String checkOut) {


        String sql = "SELECT  DISTINCT mydb.room1.room_type,  mydb.category_price.price, mydb.room1.room_no\n" +
                "                FROM mydb.room1 \n" +
                "                JOIN  mydb.category_price USING (room_type)\n" +
                "                LEFT JOIN mydb.booking ON (mydb.room1.room_no =mydb.booking.room_no)\n" +
                "                   and (\n" +
                "                      (? between mydb.booking.check_in and mydb.booking.cheсk_out) or \n" +
                "                      (? between mydb.booking.check_in and mydb.booking.cheсk_out) or \n" +
                "                      (mydb.booking.check_in between ? and ?))\n" +
                "                  WHERE  COALESCE(mydb.booking.id_guest,0) in (0);";


        return jdbcTemplate.query(sql, new RoomMapper(), checkIn,checkOut ,checkIn, checkOut);

    }

}
