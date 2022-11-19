package org.example.model;

public class FreeRoom extends Room {

    public FreeRoom() {
        this.setPrice(0.0);
    }

    @Override
    public String toString() {
        return "The free room info: " +
                "\n price: " + this.getRoomPrice() +
                "\n room number: " +this.getRoomNumber() +
                "\n room type: " + this.getRoomType();
    }
}
