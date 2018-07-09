package com.outlook.mareknowakowski.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


import java.util.*;

@NodeEntity
@EqualsAndHashCode
@ToString
public class Person {

    private String name;
    private Integer birthYear;
    private String club;
    @Relationship(type = "PLACED")
    private List<Competition> competitionList = new ArrayList<>();
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty
    private Competition competition;

    public Person() {
    }

    ;

    public Person(final String name, final Integer birthYear, final String club) {
        this.name = name;
        this.birthYear = birthYear;
        this.club = club;
    }

    public Person(@JsonProperty final String name, @JsonProperty final Integer birthYear,
                  @JsonProperty final String club, @JsonProperty Competition competition) {
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

    @Override
    public String toString() {
        return super.toString();
    }
}
