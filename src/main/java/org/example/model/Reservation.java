package org.example.model;

import java.util.Date;

public class Reservation {
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    @Override
    public String toString() {
        return "The reservation for room " + this.room.getRoomNumber() +
                "\n checkin date: " + this.checkInDate +
                "\n checkout date: " + this.checkOutDate;
    }
}
