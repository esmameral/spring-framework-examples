package com.example.cascade.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

	public Owner() {
		super();

	}

	public Owner(String name) {
		super();
		this.name = name;
	}
	/**
	 * CascadeType.PERSIST  – It means if the parent entity is saved then the related entity will also be saved. 
	 * CascadeType.MERGE    – It means if the parent entity is merged then the related entity will also be merged. 
	 * CascadeType.REMOVE   – It means if the parent entity is deleted then the related entity will also be deleted. 
	 * CascadeType.DETACH   – It means if the parent entity is detached then the related entity will also be detached.
	 * CascadeType.REFRESH  – It means if the parent entity is refreshed then the related entity will also be refreshed.
	 * CascadeType.ALL      – It is equivalent to cascade={DETACH, MERGE, PERSIST, REFRESH, REMOVE}.
	 */
	@OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, 
			cascade = CascadeType.ALL )
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
