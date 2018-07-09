package com.outlook.mareknowakowski.controller;

import com.outlook.mareknowakowski.dto.ResultDTO;
import com.outlook.mareknowakowski.model.Competition;
import com.outlook.mareknowakowski.model.Person;
import com.outlook.mareknowakowski.model.Result;
import com.outlook.mareknowakowski.repositories.CompetitionRepository;
import com.outlook.mareknowakowski.repositories.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {

    private PersonRepository personRepository;
    private CompetitionRepository competitionRepository;


    public ResultController(PersonRepository personRepository, CompetitionRepository competitionRepository) {
        this.personRepository = personRepository;
        this.competitionRepository = competitionRepository;
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    public void save(@RequestBody ResultDTO dto) {
        Competition competition = new Competition(dto.getCompetition().getName(),dto.getCompetition().getDate());
        Person person = new Person(dto.getName(),dto.getBirthYear(),dto.getClub(),competition);
        personRepository.save(person);
        Result result = new Result(person,competition);
        result.addResult(dto.getPlace());
        competition.addResult(result);
        competitionRepository.save(competition);
   }


}
