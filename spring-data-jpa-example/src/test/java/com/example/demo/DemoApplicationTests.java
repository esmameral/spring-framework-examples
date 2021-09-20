package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.model.Task;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TaskRepository;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private ProjectRepository projectRepository ;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Test
	public void testCreateProject() {
		Project project = new Project();
		project.setName("Eteration Web Portal Project");
		project.setStartDate(new Date());
		Calendar cal = Calendar.getInstance();
		cal.setTime(project.getStartDate());
		cal.add(Calendar.DATE, 120);
		project.setEndDate(cal.getTime());
		
		Employee employee1 = new Employee();
		employee1.setUsername("emeral");
		employee1.setName("Esma");
		employee1.getProjects().add(project);
		
		Employee employee2 = new Employee();
		employee2.setUsername("cdemir");
		employee2.setName("Ceren");
		employee2.getProjects().add(project);

		project.getEmployees().add(employee1);
		project.getEmployees().add(employee2);
		

		Task task1 = new Task();
		task1.setProject(project);
		task1.setOwner(employee2);
		task1.setAssignee(employee1);
		task1.setCreateDate(new Date());
		task1.setDetail("task1");
		
		
		
		Task task2 = new Task();
		task2.setProject(project);
		task2.setOwner(employee1);
		task2.setAssignee(employee2);
		task2.setCreateDate(new Date());
		task2.setDetail("task2");
		
		
		project.getTasks().add(task1);
		project.getTasks().add(task2);
		
	
		projectRepository.save(project);
		assertTrue(project.getId()>0);
	}
	
	
	@Test
	@Transactional
	@Commit
	public void addNewTask() {
		Project project=projectRepository.findById(1).get();

		Employee emp1=employeeRepository.getById(2);
		Employee emp2=employeeRepository.getById(3);
		
		Task task = new Task();
		task.setProject(project);
		task.setOwner(emp1);
		task.setAssignee(emp2);
		task.setCreateDate(new Date());
		task.setDetail("new task");
		
		
		project.getTasks().add(task);

		taskRepository.save(task);
		assertTrue(task.getId()>0);
	}
	
	@Test
	public void testRepoQuery() {
		List<Project> plist=projectRepository.findByNameLike("%Eteration%");
		assertTrue(plist.size()>0);
		for (Project project : plist) {
			System.out.println(project.getName());
		}
		
		List<Employee> empList=employeeRepository.findByUsername("cdemir");
		assertTrue(empList.size()>0);
		for (Employee employee : empList) {
			System.out.println(employee.getName()+" "+employee.getUsername());
		}
		
		List<Employee> empList1=employeeRepository.findByAssignedTasksId(4);
		assertTrue(empList1.size()>0);
		for (Employee employee : empList1) {
			System.out.println(employee.getName()+" "+employee.getUsername());
		}
		
		List<Employee> empList2=employeeRepository.findByOwnedTasksId(5);
		assertTrue(empList2.size()>0);
		for (Employee employee : empList2) {
			System.out.println(employee.getName()+" "+employee.getUsername());
		}
		
		List<Task> tasks=taskRepository.findTasks("emeral");
		assertTrue(tasks.size()>0);
		for (Task task : tasks) {
			System.out.println(task.getId()+" "+task.getDetail()+" "+task.getOwner().getUsername());
		}
	}
	
	


}
