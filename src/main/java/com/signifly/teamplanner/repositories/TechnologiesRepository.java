package com.signifly.teamplanner.repositories;

import com.signifly.teamplanner.model.Technology;
import org.springframework.data.repository.CrudRepository;

public interface TechnologiesRepository  extends CrudRepository<Technology, Long> {
}
