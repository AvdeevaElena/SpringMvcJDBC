package com.avd.service.booking;

import com.avd.entity.Book;
import com.avd.entity.Room;

import java.util.Date;
import java.util.List;

public interface BookService {

    List<Room>findAllAvailableRooms(String checkIn, String checkOut);
    void  recordBook(int book_no, int id_guest, Date check_in, Date chek_out, int room_no, double room_price) throws Exception;
    List<Book>ShowGuestBook(int book_no);
}
