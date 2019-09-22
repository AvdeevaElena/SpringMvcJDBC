package com.avd.service.guest;


import com.avd.dao.guest.GuestDao;
import com.avd.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl  implements GuestService {

    @Autowired
    public GuestDao guestDao;

    public void recordGuest(Guest guest) throws Exception {

            if (guest.getName().length() < 2) {
                throw new Exception();
            }
            guestDao.recordGuest(guest);
        }


    public List<Guest> findbyIdGuest(Guest guest)  {

       return  guestDao.findbyIdGuest(guest);
    }

}
