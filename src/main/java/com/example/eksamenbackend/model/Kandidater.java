package com.example.eksamenbackend.model;

import javax.persistence.*;

@Entity
public class Kandidater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kandidaterId;

    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    public Kandidater() {
    }

    public Kandidater(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getCandidateId() {
        return kandidaterId;
    }

    public void setCandidateId(int candidateId) {
        this.kandidaterId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getKandidaterId() {
        return kandidaterId;
    }

    public void setKandidaterId(int kandidaterId) {
        this.kandidaterId = kandidaterId;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}

