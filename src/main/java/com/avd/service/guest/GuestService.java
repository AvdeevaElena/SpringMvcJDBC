package com.avd.service.guest;

import com.avd.entity.Guest;

import java.util.List;

public interface GuestService {




    void  recordGuest(Guest guest) throws Exception;
    List<Guest> findbyIdGuest(Guest guest);
}
