package com.sense.pass.service;

import com.sense.pass.exception.CustomerNotFoundException;
import com.sense.pass.model.Customer;
import com.sense.pass.repository.CustomerRepository;
import org.springframework.stereotype.Service;

// The aim of the "CustomerService" is to send "Customer" info

@Service // A "Service" can only use the "Repository" that serves to it
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // We can use "Entities" for the operations between "Services"
    // "protected" can only be used inside the "service"
    // "findById()" returns an "Optional" which prevents "Null Pointer Exception"
    protected Customer findCustomerById(String id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer can't be found by id: " + id));
    }
}
