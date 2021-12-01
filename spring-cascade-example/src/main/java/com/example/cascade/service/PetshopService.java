package com.example.cascade.service;

import java.util.List;

import com.example.cascade.model.Owner;
import com.example.cascade.model.Pet;

public interface PetshopService {
public List<Owner> getOwners();
public Owner saveOwner(Owner owner);
public void deleteOwner(Owner owner);
public Owner getOwnerById(int id);
public Pet savePet(Pet pet);
}
