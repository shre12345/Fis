package com.fisglobal.employeemanagement;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.employeemanagement.model.Employee;
import com.fisglobal.employeemanagement.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeemanagementApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext context = SpringApplication.run(EmployeemanagementApplication.class, args);
//		 EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
//		 Employee employee = new Employee("ab001", "sh", "chivate", "sh@gmail.com", 100.0f);
//		 employeeRepository.save(employee);
//		 List<Employee> employees = employeeRepository.findAll();
//		 employees.forEach(System.out::println);
//		 context.close();
		 
	}

}
