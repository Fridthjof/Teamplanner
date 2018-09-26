package com.signifly.teamplanner.repositories;

import com.signifly.teamplanner.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
