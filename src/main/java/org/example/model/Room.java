package org.example.model;

public class Room implements IRoom {
    private String roomNumber;
    private Double price;
    private RoomType enumeration;

    @Override
    public String toString(){
        return this.enumeration + "room \n room number: " + this.roomNumber + " \n room price: " + this.price;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public Double getRoomPrice() {
        return this.price;
    }

    public RoomType getRoomType() {
        return this.enumeration;
    }

    // todo: add logic
    public boolean isFree() {
        return true;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
