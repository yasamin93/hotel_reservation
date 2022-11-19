package org.example.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    private static String validateEmail(String email) {
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        return email;
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
       this.email = Customer.validateEmail(email);
    }

    @Override
    public String toString() {
        return "Firstname: " + this.firstName + "lastname: " + this.lastName + "email: " + this.email;
    }
}
