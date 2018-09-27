package com.signifly.teamplanner.controller;
import com.signifly.teamplanner.model.Person;
import com.signifly.teamplanner.model.Team;
import com.signifly.teamplanner.model.Technology;
import com.signifly.teamplanner.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @RequestMapping(value= "/suggestTeam", method = RequestMethod.GET)
    public ResponseEntity suggestTeam(@RequestBody List<Technology> technologies){
        // Do the rating system here!
        List<Person> suggestedPersons = new ArrayList<>();

        return new ResponseEntity<>(suggestedPersons, HttpStatus.OK);
    }

    @RequestMapping(value = "/createTeam", method = RequestMethod.POST)
    public ResponseEntity createTeam(@RequestBody Team team){
        teamRepository.save(team);
        return new ResponseEntity(HttpStatus.OK);
    }
}
