package com.example.zawody.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.neo4j.driver.internal.messaging.PackStreamMessageFormatV1.RELATIONSHIP;

@NodeEntity
public class Competition {

    private String name;
    private String date;

    @Relationship(type = "PLACED",direction = Relationship.INCOMING)
    private List<Result> results = new ArrayList<>();

    @Id
    @GeneratedValue
    private Long id;
    public Competition() {};

    public Competition(@JsonProperty  String name,@JsonProperty String date) {
        this.name = name;
        this.date = date;
    }

    public void addResult(Result result) {
        this.results.add(result);
    }




}


