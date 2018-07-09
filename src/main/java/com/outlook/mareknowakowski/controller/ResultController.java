package com.outlook.mareknowakowski.controller;

import com.outlook.mareknowakowski.model.Person;
import com.outlook.mareknowakowski.model.PersonDTO;
import com.outlook.mareknowakowski.repositories.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class ResultController {

    private PersonRepository personRepository;

    public ResultController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("http://localhost:8080")
    public ResponseEntity<Void> save(@RequestBody PersonDTO person) {

        personRepository.save(new Person(person.getName(),person.getBirthYear(),person.getClub()));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{childId}").buildAndExpand(person.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
