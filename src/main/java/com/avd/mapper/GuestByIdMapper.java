package com.avd.mapper;

import com.avd.entity.Guest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GuestByIdMapper  implements RowMapper <Guest>{


    public Guest mapRow(ResultSet resultSet, int i) throws SQLException {
        Guest guest = new Guest();
        guest.setId(  resultSet.getInt("id")   );
      return guest;


    }

}
