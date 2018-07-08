package com.example.zawody.repositories;

import com.example.zawody.model.Competition;
import com.example.zawody.model.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Set;

public interface CompetitionRepository extends Neo4jRepository<Competition,Long> {

    Competition findByName(@Param("name") String name);
    Collection<Competition> findByNameLike(@Param("name") String name);


    //Set<Person> findByPersonName(String name);

    @Query("MATCH (c:Competition)<-[r:PLACED]-(a:Person) RETURN m,r,a LIMIT {limmit}")
    Collection<Competition> graph(@Param("limit") int limit);

}
