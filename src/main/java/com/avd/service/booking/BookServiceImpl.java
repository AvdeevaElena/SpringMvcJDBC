package com.avd.service.booking;

import com.avd.dao.booking.BookDao;
import com.avd.dao.room.RoomDao;
import com.avd.entity.Book;
import com.avd.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public RoomDao roomDao;
   @Autowired
    public BookDao bookDao;

    public List<Room> findAllAvailableRooms(String checkIn,String checkOut)  {
        return roomDao.findAllAvailableRooms(checkIn,checkOut); }  ;

    public void  recordBook(int book_no, int id_guest, Date check_in, Date chek_out, int room_no, double room_price) {
        bookDao.recordBook(book_no, id_guest, check_in, chek_out, room_no, room_price  ); };

    public List<Book> ShowGuestBook(int book_no ) {
        return bookDao.infoBookToGuest(book_no); };
}
