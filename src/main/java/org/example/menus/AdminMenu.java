package org.example.menus;

import org.example.api.AdminResource;
import org.example.api.HotelResource;
import org.example.model.IRoom;
import org.example.model.Room;
import org.example.model.RoomType;
import org.example.service.CustomerService;
import org.example.service.ReservationService;

import java.util.Scanner;

public class AdminMenu {
    private static final AdminResource adminResource = new AdminResource();
    private static final HotelResource hotelResource = new HotelResource();

    public static IRoom getRoom() {
        System.out.println("Insert room number:");
        Scanner objScanner = new Scanner(System.in);
        String roomNumber = objScanner.nextLine();
        System.out.println("Insert room price in with decimal point e.g. 20.0:");
        Double roomPrice = objScanner.nextDouble();
        System.out.println("Insert room type: 1. Single 2. Double");
        RoomType roomType;
        int selection = objScanner.nextInt();
        if (selection == 1){
            roomType = RoomType.SINGLE;
        } else if (selection == 2) {
            roomType = RoomType.DOUBLE;
        } else {
            System.out.println("Enter either 1 or 2.");
            // Todo
            System.out.println("Wrong choice, default room type Double chosen.");
            roomType = RoomType.DOUBLE;
        }
        return new Room(roomNumber, roomPrice, roomType);
    }
    public static void adminMenu() {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (keepRunning) {
            try {
                System.out.println("Main Menu");
                System.out.println("------------------");
                System.out.println("1. See all customers");
                System.out.println("2. See all rooms");
                System.out.println("3. See all reservations");
                System.out.println("4. Add a room");
                System.out.println("5. Back to main menu");

                int selection = Integer.parseInt(scanner.nextLine());

                if (selection == 1) {
                    adminResource.getAllCustomers();
                } else if (selection == 2) {
                    adminResource.getAllRooms();
                } else if (selection == 3) {
                    adminResource.displayAllReservations();
                } else if (selection == 4) {
                    IRoom room = getRoom();
                    adminResource.addRoom(room);
                } else if (selection == 5) {
                    keepRunning = false;
                    break;
                }
            } catch (Exception ex) {
                System.out.println("\n Error - Invalid Input");
            }
        }
    }
}
