package org.example.model;

import java.util.Date;

public class Reservation {
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(IRoom room, Date checkInDate, Date checkOutDate) {
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "The reservation for room " + this.room.getRoomNumber() +
                "\n checkin date: " + this.checkInDate +
                "\n checkout date: " + this.checkOutDate;
    }
}
