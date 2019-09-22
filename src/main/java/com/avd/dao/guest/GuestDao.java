package com.avd.dao.guest;

import com.avd.entity.Guest;

import java.util.List;

public interface GuestDao {

    void  recordGuest(Guest guest);
    List<Guest> findbyIdGuest(Guest guest);

}
