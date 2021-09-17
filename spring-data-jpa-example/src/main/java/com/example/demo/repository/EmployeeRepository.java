package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {	
	public List<Employee> findEmployeeByUsername(String username);
	
	public List<Employee> findEmployeesByAssignedTasksId(@Param("id") int id);
	
	public List<Employee> findEmployeesByOwnedTasksId(@Param("id") int id);
}
