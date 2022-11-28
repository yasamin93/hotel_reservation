package org.example.service;

import org.example.model.Customer;

import java.util.*;

public class CustomerService {
    private static final Map<String, Customer> customersMap = new HashMap<>();

    public void addCustomer(String email, String firstName, String lastName) {
        var customer = new Customer(firstName, lastName, email);
        customersMap.put(email, customer);
    }

    public Customer getCustomer(String customerEmail) {
        return customersMap.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        var customers = customersMap.values();
        for (Customer customer: customers) {
            System.out.println("Customer:\n" + customer);
        }
        return customers;
    }
}
