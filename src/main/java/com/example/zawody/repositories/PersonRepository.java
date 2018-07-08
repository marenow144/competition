package com.example.zawody.repositories;

import com.example.zawody.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PersonRepository extends Neo4jRepository<Person,Long> {

    Person findByName(String name);
}
