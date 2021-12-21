package com.example.eksamenbackend.repositories;

import com.example.eksamenbackend.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Integer> {
}
