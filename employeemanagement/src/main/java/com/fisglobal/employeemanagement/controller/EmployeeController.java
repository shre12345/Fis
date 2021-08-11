package com.fisglobal.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.employeemanagement.exception.ResourceNotFound;
import com.fisglobal.employeemanagement.model.Employee;
import com.fisglobal.employeemanagement.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//@GETMapping : to inform that we are going to use GET method.
	//@Description: used to get all records 
	// @return : will return the data interms of json object array
	// @type : public : any one can access it.(no JWT tokens ) 
	// will help u to confirm your identity.
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		if(employees.size()>0) {
		return ResponseEntity.status(HttpStatus.OK).body(employees);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body("No records found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id) throws ResourceNotFound{
		
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("employee not found :: " +id));
		return ResponseEntity.ok().body(employee);
				
		
//		Optional<Employee> optional = employeeRepository.findById(id);
//		
//		if(optional.isPresent()) {
//			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("record not found");
//		}
	}
	@PostMapping("/createEmployee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		
		System.out.println(employee);
		return ResponseEntity.status(201).body(employee);
	}

}
