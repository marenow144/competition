package com.outlook.mareknowakowski.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NodeEntity
public class Person {

    private String name;
    private Integer birthYear;
    @Relationship(type = "BELONGS_TO")
    private Club club;
    @Relationship(type = "STARTED_IN")
    private List<Competition> competitionList = new ArrayList<>();
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty
    private Competition competition;

    public Person() {
    }

    ;

    public Person(final String name, final Integer birthYear, final Club club) {
        this.name = name;
        this.birthYear = birthYear;
        this.club = club;
    }

    public Person(@JsonProperty final String name, @JsonProperty final Integer birthYear,
                  @JsonProperty final Club club, @JsonProperty Competition competition) {
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

    public Club getClub() {
        return club;
    }

    public List<Competition> getCompetitionList() {
        return competitionList;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(birthYear, person.birthYear) &&
                Objects.equals(club, person.club) &&
                Objects.equals(competitionList, person.competitionList) &&
                Objects.equals(id, person.id) &&
                Objects.equals(competition, person.competition);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, birthYear, club, competitionList, id, competition);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", club='" + club + '\'' +
                ", competitionList=" + competitionList +
                ", id=" + id +
                ", competition=" + competition +
                '}';
    }
}
