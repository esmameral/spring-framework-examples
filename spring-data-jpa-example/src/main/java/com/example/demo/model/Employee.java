package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public  class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String username;
	@OneToMany(mappedBy="assignee",cascade=CascadeType.ALL)
	private List<Task> assignedTasks = new ArrayList<Task>();

	@OneToMany(mappedBy="owner",cascade=CascadeType.ALL)
	private List<Task> ownedTasks = new ArrayList<Task>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "PROJECT_EMPL")
	private List<Project> projects = new ArrayList<Project>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	

	public List<Task> getAssignedTasks() {
		return assignedTasks;
	}

	public void setAssignedTasks(List<Task> assignedTasks) {
		this.assignedTasks = assignedTasks;
	}

	public List<Task> getOwnedTasks() {
		return ownedTasks;
	}

	public void setOwnedTasks(List<Task> ownedTasks) {
		this.ownedTasks = ownedTasks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
