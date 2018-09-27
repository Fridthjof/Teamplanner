package com.signifly.teamplanner.repositories;

import com.signifly.teamplanner.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository  extends CrudRepository<Customer, Long> {
}
