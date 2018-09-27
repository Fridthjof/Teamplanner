package com.signifly.teamplanner.repositories;

import com.signifly.teamplanner.model.Technology;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TechnologyRepository extends CrudRepository<Technology, Long> {

    Technology findByName(String name);

    @Query(value="SELECT * FROM Technology ORDER BY RAND() LIMIT 4", nativeQuery = true)
    List<Technology> findRand();
}
