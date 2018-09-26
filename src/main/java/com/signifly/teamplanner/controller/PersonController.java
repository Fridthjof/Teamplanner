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
import org.springframework.web.bind.annotation.RequestMapping;
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
            JsonReader reader = new JsonReader(new FileReader("src/test/resources/mockdata/persons.json"));
            Person[] people = g.fromJson(reader, Person[].class);

            List<Technology> technologyList = new ArrayList<>();
            technologyList.add(technologyRepository.findByName("Java"));
            technologyList.add(technologyRepository.findByName("C#"));
            technologyList.add(technologyRepository.findByName("JavaScript"));
            technologyList.add(technologyRepository.findByName("PHP"));

            for (Person person : people) {
                person.setTechnologies(technologyList);
                personRepository.save(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
