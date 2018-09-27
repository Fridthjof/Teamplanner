package com.signifly.teamplanner.controller;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.signifly.teamplanner.model.Technology;
import com.signifly.teamplanner.repositories.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {


    @Autowired
    private TechnologyRepository technologyRepository;

    public TechnologyController(TechnologyRepository technologyRepository) {
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
            JsonReader reader = new JsonReader(new FileReader("src/test/resources/mockdata/technologies.json"));
            Technology[] tech = g.fromJson(reader, Technology[].class);
            for (Technology technology : tech) {
                technologyRepository.save(technology);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/getAllTechs", method = RequestMethod.GET)
    public ResponseEntity getAllTechs(){
        return new ResponseEntity(technologyRepository.findAll(), HttpStatus.OK);
    }
}
