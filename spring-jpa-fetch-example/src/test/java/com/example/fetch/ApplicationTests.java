package com.example.fetch;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.fetch.model.Owner;
import com.example.fetch.service.PetshopService;

@SpringBootTest
class ApplicationTests {
	@Autowired
	PetshopService petshopService;

	@Test
	void ownerLoad() {
		List<Owner> owners=petshopService.getOwners();
		
	}

}
