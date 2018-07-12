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
public class Competition {

    private String name;
    private String date;

    @Relationship(type = "STARTED_IN", direction = Relationship.INCOMING)
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

    @Override
    public String toString() {
        return "Competition{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", results=" + results +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(date, that.date) &&
                Objects.equals(results, that.results) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, date, results, id);
    }
}


