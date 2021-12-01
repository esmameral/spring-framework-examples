package com.example.cascade.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cascade.model.Owner;
import com.example.cascade.model.Pet;
import com.example.cascade.service.PetshopService;

@SpringBootTest
class CascadeTest {
	@Autowired
	PetshopService petshopService;
	
	/**
	 * Case 1: No cascade => insert owner, don't insert Pet
	 * Case 2: CascadeType.PERSIST => insert owner and Pet
	 */
	@Test
	void case1_2() {
		Owner owner=new Owner("Esma Meral");
		Pet pet = new Pet("Blue parrotlet");
		pet.setOwner(owner);
		owner.getPets().add(pet);
		petshopService.saveOwner(owner);
		
		
	}
	
	/**
	 * Case 3: CascadeType.REMOVE EXISTS => Delete Owner and related pets
	 * Case 4: CascadeType.REMOVE NOT EXISTS => Exception: DataIntegrityViolationException (Foreign Key) 
	 */
	@Test
	void case3_4() {
		Owner owner=petshopService.getOwnerById(100);
		petshopService.deleteOwner(owner);
	}
	
	/**
	 * Case 5: CascadeType.MERGE EXISTS => Update Owner and Pet
	 * Case 6: CascadeType.MERGE NOT EXISTS => Update Owner, Don't update Pet
	 */
	@Test
	void case5_6() {
		Owner owner=petshopService.getOwnerById(100);
		owner.setName("Esma Meral");
		owner.getPets().get(0).setBreed("Blue parrotlet");
		petshopService.saveOwner(owner);
		
	}

}
