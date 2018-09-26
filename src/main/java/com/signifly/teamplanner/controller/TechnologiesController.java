package com.signifly.teamplanner.controller;

import com.signifly.teamplanner.repositories.TechnologiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {


    @Autowired
    private TechnologiesRepository technologiesRepository;


    public TechnologiesController(TechnologiesRepository technologiesRepository) {
        this.technologiesRepository = technologiesRepository;
    }

    @RequestMapping("/MockData")
    public ResponseEntity createMockData(){


        return new ResponseEntity(HttpStatus.OK);
    }

}
