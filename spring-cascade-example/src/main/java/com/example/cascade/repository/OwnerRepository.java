package com.example.cascade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cascade.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
