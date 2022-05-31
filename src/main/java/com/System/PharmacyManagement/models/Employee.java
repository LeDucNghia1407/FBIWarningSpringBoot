package com.System.PharmacyManagement.models;

public class Employee {
	private String employeeID;
	private String drugStoreID;
	private String managerBy;
	private String name;
	private String email;
	private int phone;
	private byte permission;
	private int salary;

public void setEmployee(String employeeID, String drugStoreID, String managerBy, String name, String email, int phone, byte permission, int salary) {
		this.employeeID = employeeID;
		this.drugStoreID = drugStoreID;
		this.managerBy = managerBy;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.permission = permission;
		this.salary = salary;
}

public String getEmployeeID() {
	return employeeID;
}
public String getDrugStoreID() {
	return drugStoreID;
}
public String getManagerBy() {
	return managerBy;
}
public String getName() {
	return name;
}
public String getEmail() {
	return email;
}
public int getPhone() {
	return phone;
}
public byte getPermission() {
	return permission;
}
public int getSalary() {
	return salary;
}
}


