package com.outlook.mareknowakowski.model;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Club {
    @Id
    @GeneratedValue
    Long id;

    private String name;
    @Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
    private List<Belong> belongings = new ArrayList<>();

    public Club() {};

    public Club(String name) {
        this.name = name;
    }


}
