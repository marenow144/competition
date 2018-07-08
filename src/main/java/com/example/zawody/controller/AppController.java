package com.example.zawody.controller;


import com.example.zawody.model.DTO;
import com.example.zawody.model.Person;
import com.example.zawody.repositories.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class AppController {

    PersonRepository personRepository;

    public AppController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/posted",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("http://localhost:8080")
    public ResponseEntity<Void>save(@RequestBody Person person) {

        personRepository.save(person);
       URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{childId}").buildAndExpand(person.getId())
              .toUri();
        return ResponseEntity.created(location).build();
    }


}
