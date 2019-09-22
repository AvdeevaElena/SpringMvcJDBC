package com.avd.entity;

public class Room {

    private int id;
    private String status;
    private String category;
    private int room_no;
    private double roomPrice;

    private String roomNoAndPrice;


    public String getRoomNoAndPrice() { return roomNoAndPrice; }
    public void setRoomNoAndPrice(String roomNoAndPrice) { this.roomNoAndPrice = roomNoAndPrice; }

    private String checkIn;
    private String checkOut;

    public int getRoom_no() { return room_no; }
    public void setRoom_no(int room_no) { this.room_no = room_no; }

    public String getCheckIn() { return checkIn; }
    public void setCheckIn(String checkIn) { this.checkIn = checkIn;}
    public String getCheckOut() { return checkOut; }
    public void setCheckOut(String checkOut) { this.checkOut = checkOut; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getRoomPrice() { return roomPrice; }
    public void setRoomPrice(double roomPrice) { this.roomPrice = roomPrice; }

    public Room() { }
}
