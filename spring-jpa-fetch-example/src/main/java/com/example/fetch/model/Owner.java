package com.example.fetch.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	/**
	 *  EAGER fetching tells Hibernate to get the related entities with the initial query. 
	 *  This can be very efficient because all entities are fetched with only one query. 
	 *  But in most cases it just creates a huge overhead because you select entities 
	 *  you don’t need in your use case.
	 *  You can prevent this with FetchType.LAZY. 
	 *  This tells Hibernate to delay the initialization of the relationship until you access it in your 
	 *  business code. The drawback of this approach is that Hibernate needs to execute an additional 
	 *  query to initialize each relationship.
	 *  
	 */
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
	private List<Pet> pets = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}
