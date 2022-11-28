package org.example.model;

public class FreeRoom extends Room {

    public FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super(roomNumber, price, enumeration);
        this.setPrice(0.0);
        System.out.println("Free room initialized with 0 price.");
    }

    @Override
    public String toString() {
        return "The free room info: " +
                "\n price: " + this.getRoomPrice() +
                "\n room number: " +this.getRoomNumber() +
                "\n room type: " + this.getRoomType();
    }
}
