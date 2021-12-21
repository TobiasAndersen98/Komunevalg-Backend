package com.example.eksamenbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partyId;

    @OneToMany
    @JoinColumn(name = "party_id")
    @JsonBackReference
    private Set<Kandidater> kandidaters = new HashSet<>();

    private String name;






    public Party() {
    }

    public Party(int partyId, String name) {
        this.partyId = partyId;
        this.name = name;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Kandidater> getKandidaters() {
        return kandidaters;
    }

    public void setKandidaters(Set<Kandidater> kandidaters) {
        this.kandidaters = kandidaters;
    }

}
