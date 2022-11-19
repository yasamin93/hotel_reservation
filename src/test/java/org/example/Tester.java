package org.example;

import org.example.model.Customer;

public class Tester {
    public static void main(String[] args) {
        Customer trueCustomer = new Customer("first", "last", "c@gmail.com");
        System.out.println(trueCustomer);

        // Customer falseCustomer = new Customer("first", "last", "email");
        System.out.println("Printing falseCustomer should throw exception and break the validation.");
    }
}
