package com.signifly.teamplanner.repositories;

import com.signifly.teamplanner.model.Technology;
import org.springframework.data.repository.CrudRepository;

public interface TechnologyRepository extends CrudRepository<Technology, Long> {

    Technology findByName(String name);
}
