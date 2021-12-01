package com.example.cascade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String breed;
	
	@ManyToOne()
	private Owner owner;
	
	public Pet() {
		super();
	}
	
	public Pet(String breed) {
		super();
		this.breed = breed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	

}
