package com.avd.dao.guest;

import com.avd.entity.Guest;
import com.avd.mapper.GuestByIdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestDaoImpl implements GuestDao {

    @Autowired
    public final JdbcTemplate jdbcTemplate;


    public GuestDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   public void  recordGuest( Guest guest ) {
       String sql = "INSERT INTO mydb.guest (name, last_name, email, age ) VALUES(?, ?, ?, ?);";
       jdbcTemplate.update(sql, guest.getName(),guest.getLastName() ,guest.getEmail(), guest.getAge());
   }



    public List<Guest> findbyIdGuest (Guest guest) {
        String sql = "SELECT id FROM mydb.guest where email in (?); ";
        return jdbcTemplate.query(sql,  new GuestByIdMapper(), guest.getEmail() );
    }

}
