package com.example.zawody.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


import java.util.*;
import java.util.stream.Collectors;

@NodeEntity
public class Person {

    private String name;
   // private final String surname;
    private Integer birthYear;
    private String club;
    @Relationship(type = "PLACED")
    private List<Competition> competitionList = new ArrayList<>();
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty
    Competition competition;
    protected Person() {};

    public Person(final String name,final Integer birthYear,final String club) {
        this.name = name;
        this.birthYear = birthYear;
        this.club = club;
    }

    public Person(@JsonProperty final String name, @JsonProperty final Integer birthYear,
                  @JsonProperty final String club, @JsonProperty  Competition competition) {
        this.name = name;
        //this.surname = surname;
        this.birthYear = birthYear;
        this.club = club;
        startedIn(competition);
    }


    public void startedIn(Competition competition) {
        this.competitionList.add(competition);
    }

    public String getName() {
        return name;
    }


    public Integer getBirthYear() {
        return birthYear;
    }

    public String getClub() {
        return club;
    }

    public List<Competition> getCompetitionList() {
        return competitionList;
    }

    public Long getId() {
        return id;
    }
//    public String toString() {
//
//        return this.name + "'s teammates => "
//                + Optional.ofNullable(this.teammates).orElse(
//                Collections.emptySet()).stream()
//                .map(Person::getName)
//                .collect(Collectors.toList());
//    }
}
