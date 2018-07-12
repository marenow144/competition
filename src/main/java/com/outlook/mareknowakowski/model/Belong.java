package com.outlook.mareknowakowski.model;


import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type = "BELONGS_TO")
public class Belong {
    @Id
    @GeneratedValue
    Long id;

    private List<String> since = new ArrayList<>();

    @StartNode
    private Person person;
    @EndNode
    private Club club;

    public Belong(Person person, Club club) {
        this.person = person;
        this.club = club;
    }

    public void add(String since){
        this.since.add(since);
    }

}
