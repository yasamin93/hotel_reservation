package org.example.service;

import org.example.model.Customer;

import java.util.*;

public class CustomerService {
    private static Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(String email, String firstName, String lastName) {
        var customer = new Customer(firstName, lastName, email);
        customers.put(email, customer);
    }

    public Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
