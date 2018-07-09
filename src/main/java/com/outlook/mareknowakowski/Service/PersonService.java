package com.outlook.mareknowakowski.Service;

import com.outlook.mareknowakowski.model.Person;
import com.outlook.mareknowakowski.repositories.PersonRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Transactional(readOnly = true)
    public Person findByName(String name) {
       return personRepository.findByName(name);
    }

    public static Person addPerson(Scanner s) {

       // Scanner s = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = s.next();
        System.out.println("Enter birth year: " );
        Integer birthYear = s.nextInt();
        System.out.println("Enter club name: ");
        String club = s.next();
        return new Person(name,birthYear,club);
        //repository.save(new Person(name,surname,birthYear,club));
    }

}
