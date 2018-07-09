package com.outlook.mareknowakowski.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type = "PLACED")
@EqualsAndHashCode
@ToString
public class Result {
    @Id
    @GeneratedValue
    private Long id;

    private String category;

    public Result() {
    }

    ;

    private List<Integer> results = new ArrayList<>();

    public Result(final Person person, final Competition competition) {
        this.person = person;
        this.competition = competition;
    }

    @StartNode
    private Person person;
    @EndNode
    private Competition competition;


    public void addResult(Integer result) {
        this.results.add(result);
    }


}
