package com.example.demo.model.atp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UM_APP")
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToMany(mappedBy ="appList" )
	private List<Tenant> tenantList;
	
	@OneToMany(mappedBy = "app")
	private List<Menu> menuList;
	
	@OneToMany(mappedBy = "app")
	private List<Role> roleList;
}


