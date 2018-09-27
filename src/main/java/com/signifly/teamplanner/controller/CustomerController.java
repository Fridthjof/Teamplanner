package com.signifly.teamplanner.controller;

import com.signifly.teamplanner.model.Customer;
import com.signifly.teamplanner.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @RequestMapping(value =  "/createCustomer", method = RequestMethod.POST)
    public ResponseEntity createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }
}
