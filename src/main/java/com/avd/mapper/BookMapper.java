package com.avd.mapper;

import com.avd.entity.Book;
import com.avd.entity.Guest;
import com.avd.entity.Room;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setBook_no(resultSet.getInt("book_no"));

        Guest bookGuet = new Guest();
        bookGuet.setId(resultSet.getInt("id_guest"));
        book.setGuest(bookGuet);

        System.out.println(" in BookMapper  getId()" +book.getGuest().getId());

        Room bookRoom = new Room();
        bookRoom.setCheckIn(resultSet.getDate("check_in").toString());
        bookRoom.setCheckOut(resultSet.getDate("cheсk_out").toString());
        bookRoom.setRoom_no(resultSet.getInt("room_no"));
        book.setRoom(bookRoom);

        book.setBookPrice(resultSet.getDouble("total_price"));
        book.setDateBook(resultSet.getDate("date_book"));
        return book;
    }
}
