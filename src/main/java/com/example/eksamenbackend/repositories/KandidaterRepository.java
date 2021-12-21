package com.example.eksamenbackend.repositories;

import com.example.eksamenbackend.model.Kandidater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KandidaterRepository extends JpaRepository<Kandidater, Integer> {
}
