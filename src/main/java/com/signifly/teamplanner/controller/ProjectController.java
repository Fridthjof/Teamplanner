package com.signifly.teamplanner.controller;
import com.signifly.teamplanner.model.Project;
import com.signifly.teamplanner.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public ResponseEntity createProject(@RequestBody Project project) {
        projectRepository.save(project);
        return new ResponseEntity(HttpStatus.OK);
    }
}
