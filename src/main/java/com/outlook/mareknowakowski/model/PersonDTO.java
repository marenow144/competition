package com.outlook.mareknowakowski.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public class PersonDTO {
    private String name;
    private Integer birthYear;
    private String club;
    @Id
    @GeneratedValue
    private Long id;

    public String getName() {
        return name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public String getClub() {
        return club;
    }

    public Long getId() {
        return id;
    }
}
