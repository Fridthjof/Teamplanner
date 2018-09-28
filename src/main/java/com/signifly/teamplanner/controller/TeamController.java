package com.signifly.teamplanner.controller;

import com.signifly.teamplanner.model.Person;
import com.signifly.teamplanner.model.Team;
import com.signifly.teamplanner.model.Technology;
import com.signifly.teamplanner.repositories.PersonRepository;
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
    private PersonRepository personRepository;

    public TeamController(TeamRepository teamRepository, PersonRepository personRepository) {
        this.teamRepository = teamRepository;
        this.personRepository = personRepository;
    }


    @RequestMapping(value = "/suggestTeam", method = RequestMethod.POST)
    public ResponseEntity suggestTeam(@RequestBody List<Technology> technologies) {
        // Do the rating system here!
        System.out.println("Do we even get in here");
        List<Person> suggestedPersons = new ArrayList<>();
        List<Person> people = personRepository.findAll();
        int calc = 100 / technologies.size();
        for (Person p : people) {

            int rating = 0;
            for (Technology technology : technologies) {
                for (Technology technology1 : p.getTechnologies()){
                    if (technology1.getId().equals(technology.getId())) {
                        rating = rating + calc;
                        p.setRatingNumber(rating);
                    }
                }
            }
            suggestedPersons.add(p);
        }
        return new ResponseEntity<>(suggestedPersons, HttpStatus.OK);
    }

    @RequestMapping(value = "/createTeam", method = RequestMethod.POST)
    public ResponseEntity createTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return new ResponseEntity(HttpStatus.OK);
    }
}
