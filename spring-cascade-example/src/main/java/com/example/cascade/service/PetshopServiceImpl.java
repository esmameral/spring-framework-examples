package com.example.cascade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cascade.model.Owner;
import com.example.cascade.model.Pet;
import com.example.cascade.repository.OwnerRepository;
import com.example.cascade.repository.PetRepository;

@Service
public class PetshopServiceImpl implements PetshopService {

	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	PetRepository petRepository;
	
	@Override
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}
	
	@Override
	public Owner saveOwner(Owner owner) {
		return ownerRepository.save(owner);
	}
	
	@Override
	public void deleteOwner(Owner owner) {
		ownerRepository.delete(owner);
		
	}
	@Override
	public Owner getOwnerById(int id) {
		return ownerRepository.findById(id).get();
	}
	
	@Override
	public List<Owner> getOwners() {
		return ownerRepository.findAll();
	}

}
