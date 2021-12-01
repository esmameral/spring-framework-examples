package com.example.fetch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fetch.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
