package com.System.PharmacyManagement.models;

public class Employee {
	private int employeeID;
	private int drugStoreID;
	private int managerID;
	private String name;
	private String email;
	private String phone;
	private int permission;
	private int salary;

public void setEmployee(int employeeID, int drugStoreID, int managerBy, String name, String email, String phone, byte permission, int salary) {
		this.employeeID = employeeID;
		this.drugStoreID = drugStoreID;
		this.managerID = managerBy;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.permission = permission;
		this.salary = salary;
}

public int getEmployeeID() {
	return employeeID;
}
public int getDrugStoreID() {
	return drugStoreID;
}
public int getManagerBy() {
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


