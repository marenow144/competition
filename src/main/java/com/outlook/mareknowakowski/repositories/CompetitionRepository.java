package com.outlook.mareknowakowski.repositories;

import com.outlook.mareknowakowski.model.Competition;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CompetitionRepository extends Neo4jRepository<Competition, Long> {

    Competition findByName(@Param("name") String name);

    Collection<Competition> findByNameLike(@Param("name") String name);

    @Query("MATCH (c:Competition)<-[r:PLACED]-(a:Person) RETURN m,r,a LIMIT {limmit}")
    Collection<Competition> graph(@Param("limit") Integer limit);

}
