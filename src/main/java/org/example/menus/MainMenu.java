package org.example.menus;

import org.example.api.AdminResource;
import org.example.api.HotelResource;
import org.example.model.Customer;
import org.example.model.IRoom;
import org.example.model.Reservation;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.example.menus.AdminMenu.adminMenu;

public class MainMenu {
    public static final HotelResource hotelResource = new HotelResource();
    public static final AdminResource adminResource = new AdminResource();

    public static List<Date> getReservationDates() throws ParseException {
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Enter CheckIn date mm/dd/yyyy example 02/01/2022");
        SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
        Date checkInDate = format.parse("01/01/2000");
        Date checkOutDate = format.parse("01/01/2000");
        try {
            checkInDate = format.parse(objScanner.nextLine());
        } catch (Exception ex) {
            System.out.println("\n Error - Please give a correct date.");
            System.out.println("error: " + ex.getLocalizedMessage());
        }
        System.out.println("Enter CheckOut date mm/dd/yyyy example 02/01/2022");
        try {
            checkOutDate = format.parse(objScanner.nextLine());
        } catch (Exception ex) {
            System.out.println("\n Error - Please give a correct date.");
            System.out.println("error: " + ex.getLocalizedMessage());
        }
        return Arrays.asList(checkInDate, checkOutDate);
    }
    public static List<String> getInputCustomer() {
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Insert the email:");
        String email = objScanner.nextLine();
        System.out.println("Insert the firstname:");
        String firstName = objScanner.nextLine();
        System.out.println("Insert the lastname:");
        String lastName = objScanner.nextLine();
        return Arrays.asList(email, firstName, lastName);
    }

    public static void main(String[] args) {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (keepRunning) {
            try {
                System.out.println("Main Menu");
                System.out.println("------------------");
                System.out.println("1. Find and reserve a room");
                System.out.println("2. See my reservations");
                System.out.println("3. Create an account");
                System.out.println("4. Admin");
                System.out.println("5. Exit");
                int selection = Integer.parseInt(scanner.nextLine());

                if (selection == 1) {
                    List<Date> reservationDates = getReservationDates();
                    Collection<IRoom> rooms = hotelResource.findARoom(reservationDates.get(0), reservationDates.get(1));
                    if (rooms.size() > 0) {
                        Scanner objScanner = new Scanner(System.in);
                        System.out.println("Would you like to book a room? y/n");
                        String isBook = objScanner.nextLine();
                        if (isBook.equals("y")) {
                            Scanner accountScanner = new Scanner(System.in);
                            System.out.println("Do you have an account with us? y/n");
                            String hasAccount = accountScanner.nextLine();
                            if (hasAccount.equals("y") ) {
                                Scanner emailScanner = new Scanner(System.in);
                                System.out.println("Insert the email:");
                                String email = emailScanner.nextLine();
                                Scanner roomScanner = new Scanner(System.in);
                                System.out.println("Which room would you like to reserve?");
                                String roomNumber = roomScanner.nextLine();
                                IRoom room = adminResource.getRoom(roomNumber);
                                hotelResource.bookARoom(email, room, reservationDates.get(0), reservationDates.get(1));
                            } else{
                                System.out.println("Please go to the main menu and create an account.");
                            }
                        } else {
                                System.out.println("Thanks for your visit to our system!");
                        }
                    } else {
                        System.out.println("We have no room available at the moment.");
                        break;
                    }
                } else if (selection == 2) {
                    Scanner accountScanner = new Scanner(System.in);
                    System.out.println("Enter your email please:");
                    String email = accountScanner.nextLine();
                    hotelResource.getCustomersReservations(email);
                } else if (selection == 3) {
                    List<String> inputCustomer = getInputCustomer();
                    hotelResource.createACustomer(
                            inputCustomer.get(0),
                            inputCustomer.get(1),
                            inputCustomer.get(2));
                } else if (selection == 4) {
                    adminMenu();
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
