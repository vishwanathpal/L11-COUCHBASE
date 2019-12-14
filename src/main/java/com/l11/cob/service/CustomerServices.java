package com.l11.cob.service;

import com.l11.cob.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServices {

    public void addCustomer(Customer customer);
    public Iterable<Customer> fetchAllCustomer();
    Boolean delete(int id);
    Optional<Customer> findById(int id);
    List<Customer> findByName(String name);
    List<Customer> findAllCustomerQuery();
}
