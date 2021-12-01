package com.example.fetch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fetch.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
