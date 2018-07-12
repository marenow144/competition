package com.outlook.mareknowakowski.controller;

import com.outlook.mareknowakowski.dto.ResultDTO;
import com.outlook.mareknowakowski.model.*;
import com.outlook.mareknowakowski.repositories.ClubRepository;
import com.outlook.mareknowakowski.repositories.CompetitionRepository;
import com.outlook.mareknowakowski.repositories.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {

    private PersonRepository personRepository;
    private CompetitionRepository competitionRepository;
    private ClubRepository clubRepository;

    public ResultController(PersonRepository personRepository, CompetitionRepository competitionRepository, ClubRepository clubRepository) {
        this.personRepository = personRepository;
        this.competitionRepository = competitionRepository;
        this.clubRepository = clubRepository;
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    public void save(@RequestBody ResultDTO dto) {
        Competition competition = new Competition(dto.getCompetition().getName(),dto.getCompetition().getDate());
        Club club = new Club(dto.getClub());
        Person person = new Person(dto.getName(),dto.getBirthYear(),club);
        personRepository.save(person);
        Belong belong = new Belong(person,club);
        clubRepository.save(club);

        Result result = new Result(person,competition);
        result.setCategory(dto.getCategory());
        result.setPlace(dto.getPlace());
        result.addResult(result);
        competition.addResult(result);
        competitionRepository.save(competition);
   }


}
