package com.avd.entity;

import java.sql.Date;

public class Book {

    private int id;
    private int book_no;
    private Room room;
    private Guest guest;
    private double bookPrice;
    private Date dateBook;

    public double getBookPrice() { return bookPrice; }

    public void setBookPrice(double totalPrice) { this.bookPrice = totalPrice; }
    public Date getDateBook() { return dateBook; }
    public void setDateBook(Date dateBook) { this.dateBook = dateBook; }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getBook_no() { return book_no; }
    public void setBook_no(int book_no) { this.book_no = book_no; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
    public Guest getGuest() { return guest; }
    public void setGuest(Guest guest) { this.guest = guest; }
}
