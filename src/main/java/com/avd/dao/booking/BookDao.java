package com.avd.dao.booking;

import com.avd.entity.Book;

import java.util.Date;
import java.util.List;

public interface BookDao {

    void recordBook(int book_no, int id_guest, Date check_in, Date chek_out, int room_no, double price);
    List<Book> infoBookToGuest(int book_no);

}
