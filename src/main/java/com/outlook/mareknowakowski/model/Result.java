package com.outlook.mareknowakowski.model;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type = "STARTED_IN")
public class Result {
    @Id
    @GeneratedValue
    private Long id;
    private Integer place;
    private String category;

    public Result() {
    }

    ;

    public void setPlace(Integer place) {
        this.place = place;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private List<Result> results = new ArrayList<>();

    public Result(final Person person, final Competition competition) {
        this.person = person;
        this.competition = competition;
    }
    @StartNode
    private Person person;
    @EndNode
    private Competition competition;


    public void addResult(Result result) {
        this.results.add(result);
    }
}
