package com.System.PharmacyManagement.models;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@SequenceGenerator(
			name = "employee_sequence",
			sequenceName = "employee_sequence",
			allocationSize = 1 //increment by 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator =  "employee_sequence"
	)
	@Column(name = "id", nullable = false)
	private Long id;

	private String employeeID;
	private String drugStoreID;
	private String managerID;
	private String name;
	private String email;
	private String phone;
	private int permission;
	private int salary;

	public Employee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee(String employeeID, String drugStoreID, String managerID, String name, String email, String phone, int permission, int salary) {
		this.employeeID = employeeID;
		this.drugStoreID = drugStoreID;
		this.managerID = managerID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.permission = permission;
		this.salary = salary;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public void setDrugStoreID(String drugStoreID) {
		this.drugStoreID = drugStoreID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmployeeID() {
	return employeeID;
}
public String getDrugStoreID() {
	return drugStoreID;
}
public String getManagerBy() {
	return managerID;
}
public String getName() {
	return name;
}
public String getEmail() {
	return email;
}
public String getPhone() {
	return phone;
}
public int getPermission() {
	return permission;
}
public int getSalary() {
	return salary;
}
}


