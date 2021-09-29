package com.securemetric.infomanager.service;

import com.securemetric.infomanager.entity.Customer;
import com.securemetric.infomanager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
}
