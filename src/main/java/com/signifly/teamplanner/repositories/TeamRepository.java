package com.signifly.teamplanner.repositories;

import com.signifly.teamplanner.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
