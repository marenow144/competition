package com.example.zawody.model;

import org.neo4j.ogm.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RelationshipEntity(type = "PLACED")
public class Result {
//    private Integer place;
//    private Integer points;
    @Id
    @GeneratedValue
    private Long id;

    private String category;
    public Result() {};

//    public Result(Integer place, Integer points) {
//        this.place = place;
//        this.points = points;
//    }
    private List<Integer> results = new ArrayList<>();
    //private Map<Result,Person> results = new HashMap<>();
    public Result(Person person, Competition competition) {
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
