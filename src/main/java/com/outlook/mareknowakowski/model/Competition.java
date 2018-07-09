package com.outlook.mareknowakowski.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@EqualsAndHashCode
@ToString
public class Competition {

    private String name;
    private String date;

    @Relationship(type = "PLACED", direction = Relationship.INCOMING)
    private List<Result> results = new ArrayList<>();

    @Id
    @GeneratedValue
    private Long id;

    public Competition() {
    }

    ;

    public Competition(@JsonProperty final String name, @JsonProperty final String date) {
        this.name = name;
        this.date = date;
    }

    public void addResult(Result result) {
        this.results.add(result);
    }


}


