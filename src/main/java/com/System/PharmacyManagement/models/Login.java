package com.System.PharmacyManagement.models;

public class Login {
	private String loginID;
	private String employeeID;
	private String password;

public Login(String loginID, String employeeID, String password) {
		this.loginID = loginID;
		this.employeeID = employeeID;
		this.password = password;
}

public void setLogin(String loginID, String employeeID, String password) {
	this.loginID = loginID;
	this.employeeID = employeeID;
	this.password = password;
}

public String getLoginID() {
	return loginID;
}
public String getEmployeeID() {
	return employeeID;
}
public String getPassword() {
	return password;
}
}

