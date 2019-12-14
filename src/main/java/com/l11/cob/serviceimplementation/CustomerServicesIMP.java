package com.l11.cob.serviceimplementation;

import com.l11.cob.model.Customer;
import com.l11.cob.repository.CoustomerRepository;
import com.l11.cob.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServicesIMP implements CustomerServices {

    @Autowired
    CoustomerRepository coustomerRepository;

    @Override
    public void addCustomer(Customer customer) {
        coustomerRepository.save(customer);
    }

    @Override
    public Iterable<Customer> fetchAllCustomer() {
        Iterable<Customer> list = coustomerRepository.findAll();
        System.out.println("List:::::::"+list);
        return list;
    }

    @Override
    public Boolean delete(int id) {
        coustomerRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Customer> findById(int id) {
        Optional<Customer> customer = coustomerRepository.findById(id);
        return customer;
    }

    @Override
    public List<Customer> findByName(String name) {
        System.out.println("ServiceIMPL::::"+name);
        List<Customer> customerList = coustomerRepository.FindCustomerByName(name);
        System.out.println("customerList::::"+customerList);
        return customerList;
    }

    @Override
    public List<Customer> findAllCustomerQuery() {
        return coustomerRepository.findCustomerAllCustomer();
    }
}
