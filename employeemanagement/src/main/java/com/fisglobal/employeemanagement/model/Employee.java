package com.fisglobal.employeemanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// ORM : Object with tables
// fields ===> columns
// ORM : object relational mapping.
@Entity
@Table(name = "empl")
public class Employee {

	@Id
	private String empId;
	@Size(min = 2, max = 15, message ="First name should have atleast 2 chars" )
	private String empFirstName;
	@Size(min = 2, max = 15, message ="Last name should have atleast 2 chars" )
	private String empLastName;
	
	@Email
	@NotNull
	private String email;
	private float empSalary;
	
}
