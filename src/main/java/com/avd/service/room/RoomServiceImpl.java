package com.avd.service.room;

import com.avd.dao.room.RoomDao;
import com.avd.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    public RoomDao roomDao;
    public List<Room> findAll() {
        return roomDao.findAll();
    }

}
