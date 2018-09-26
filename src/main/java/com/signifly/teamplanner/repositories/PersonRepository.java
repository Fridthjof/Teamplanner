package com.signifly.teamplanner.repositories;

import com.signifly.teamplanner.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
