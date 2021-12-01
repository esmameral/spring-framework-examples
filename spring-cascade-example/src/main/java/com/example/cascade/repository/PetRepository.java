package com.example.cascade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cascade.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
