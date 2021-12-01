package com.example.fetch.service;

import java.util.List;

import com.example.fetch.model.Owner;

public interface PetshopService {
public List<Owner> getOwners();
public Owner saveOwner(Owner owner);
}
