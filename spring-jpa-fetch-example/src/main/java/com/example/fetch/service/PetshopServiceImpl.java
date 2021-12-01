package com.example.fetch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fetch.model.Owner;
import com.example.fetch.repository.OwnerRepository;

@Service
public class PetshopServiceImpl implements PetshopService {

	@Autowired
	OwnerRepository ownerRepository;
	
	@Override
	public Owner saveOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	/**
	 * Case 1: fetchType=Eager => Spring will query pets data whether we need pet data or not
	 * Case 2: fetchType=Lazy and access pets: no => Spring will not query pet data
	 * Case 3: fetchType=Lazy and access pets: yes => Spring will throw following exception:
	 * 			org.hibernate.LazyInitializationException: failed to lazily initialize a 
	 * 			collection of role: com.example.fetch.model.Owner.pets, could not initialize proxy - no Session
	 * 	        =>to fix the error use @Transactional 
	 */
	@Override
	//@Transactional
	public List<Owner> getOwners() {
		System.out.println("---------------Beginning of the service method----------------");
		List<Owner> owners=ownerRepository.findAll();
		for (Owner owner : owners) {
			//System.out.println("Owner:"+owner.getName()+" Pet count: "+owner.getPets().size());
			System.out.println("Owner:"+owner.getName());
		}
		System.out.println("---------------End of the service method----------------");
		return owners;
	}

}
