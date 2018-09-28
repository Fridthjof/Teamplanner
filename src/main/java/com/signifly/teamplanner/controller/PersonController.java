package com.signifly.teamplanner.controller;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.signifly.teamplanner.model.Person;
import com.signifly.teamplanner.model.Technology;
import com.signifly.teamplanner.repositories.PersonRepository;
import com.signifly.teamplanner.repositories.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    private TechnologyRepository technologyRepository;


    public PersonController(PersonRepository personRepository, TechnologyRepository technologyRepository) {
        this.personRepository = personRepository;
        this.technologyRepository = technologyRepository;
    }

    /***
     * Method for creating mockdata
     * read JSON and insert it into DB.
     * @return HttpStatus for either OK or INTERNAL_SERVER_ERROR
     */
    @RequestMapping("/MockData")
    public ResponseEntity createMockData() {
        Gson g = new Gson();
        try {

            // Reading JSON mockdata
            JsonReader reader = new JsonReader(new FileReader("src/test/resources/mockdata/persons.json"));
            Person[] people = g.fromJson(reader, Person[].class);

            for (Person person : people) {
                person.setTechnologies(technologyRepository.findRand());
                personRepository.save(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/createPerson", method = RequestMethod.POST)
    public ResponseEntity createNewPerson(@RequestBody Person person) {
        System.out.println(person);
        System.out.println(person.getName() + " is trying to be created");
        try {
            personRepository.save(person);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


}
