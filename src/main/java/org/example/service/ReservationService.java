package org.example.service;

import org.example.model.Customer;
import org.example.model.IRoom;
import org.example.model.Reservation;
import org.example.model.Room;

import java.util.*;

public class ReservationService {
    private static Map<Customer, List<Reservation>> reservations = new HashMap<>();
    private static Map<String, IRoom> rooms = new HashMap<>();

    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomNumber) {
        return rooms.get(roomNumber);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(room, checkInDate, checkOutDate);
        List<Reservation> customerReservaations;
        if (reservations.containsKey(customer)) {
            customerReservaations = reservations.get(customer);
            customerReservaations.add(reservation);
        } else {
            customerReservaations = List.of(reservation);
        }
        reservations.put(customer, customerReservaations);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        // todo
        for (IRoom room: rooms.values()) {
            System.out.println(room.toString());
        }
        return rooms.values();
    }

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        return reservations.get(customer);
    }

    public void printAllReservation() {
        for (Customer customer: reservations.keySet()) {
                List<Reservation> customerReservations = reservations.get(customer);
                System.out.println(customer.toString());
            for (Reservation customerReservation: customerReservations) {
                System.out.println(customerReservation.toString());
            }
            System.out.println("------------------");
        }
    }
}
