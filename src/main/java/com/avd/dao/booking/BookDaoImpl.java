package com.avd.dao.booking;

import com.avd.entity.Book;
import com.avd.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    public final JdbcTemplate jdbcTemplate;


    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  void recordBook(int book_no, int id_guest, Date check_in, Date cheсk_out, int room_no, double price) {

        String sql = "INSERT INTO mydb.booking ( book_no,id_guest, check_in, cheсk_out, room_no, total_price, date_book ) VALUES( ? ,? , ? , ? , ?, DATEDIFF(?,?) * ?, now() );";
        jdbcTemplate.update(sql, book_no, id_guest ,check_in, cheсk_out, room_no, cheсk_out,check_in, price);};

    public List<Book> infoBookToGuest (int book_no) {

        String sql = " Select * from mydb.booking where book_no = ? ;";
        return jdbcTemplate.query(sql, new BookMapper(),  book_no);

    };

}
