package com.System.PharmacyManagement.models;



import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {



	@Id
	private String employeeID;
	@Column(name = "drugStoreID", nullable = false)
	private String drugStoreID;
	@Column(name = "managerID", nullable = false)
	private String managerID;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "permission", nullable = false)
	private int permission;
	@Column(name = "salary", nullable = false)
	private int salary;

	public Employee() {
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

	public String getName() {return name; }

	public String getEmail() {return email; }

	public String getPhone() {
		return phone;
	}

	public int getPermission() {
		return permission;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString()
	{
		return "Employee{"  + ", Employee ID: " +employeeID +", DrugStoreID: "+ drugStoreID+", ManagerID: "+ managerID+" Name: "+ name + "Email: " + email + "Phone: " + phone + "Permission: " + permission + "salary: " + salary + "}";
	}
}


