package com.outlook.mareknowakowski;


import com.outlook.mareknowakowski.model.Competition;
import com.outlook.mareknowakowski.model.Person;
import com.outlook.mareknowakowski.model.Result;
import com.outlook.mareknowakowski.repositories.CompetitionRepository;
import com.outlook.mareknowakowski.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@SpringBootApplication
@EnableNeo4jRepositories
public class ZawodyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZawodyApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(PersonRepository personRepository, CompetitionRepository competitionRepository) {
        return args -> {
            personRepository.deleteAll();
            competitionRepository.deleteAll();

            Competition competition = new Competition("zaowdy1", "11.12.1997");
            Competition competition1 = new Competition("zawody2", "15.10.2000");


            Person greg = new Person("Greg", 2014, "dartmoor", competition);
            Person bob = new Person("bob", 1002, "mercedes", competition1);
            greg.getCompetitionList().clear();
            bob.getCompetitionList().clear();
            personRepository.save(greg);
            personRepository.save(bob);

            personRepository.save(greg);

            bob.startedIn(competition);
            personRepository.save(bob);

            Result result1 = new Result(greg, competition);
            Result result2 = new Result(greg, competition1);
            result2.addResult(3);
            result1.addResult(1);

            Result result = new Result(bob, competition);
            result.addResult(2);
            competition.addResult(result1);
            competition1.addResult(result2);

            competitionRepository.save(competition);
            competitionRepository.save(competition1);

        };
    }
}
