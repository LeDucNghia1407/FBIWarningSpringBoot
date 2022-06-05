package com.System.PharmacyManagement.models;

import javax.persistence.*;

@Entity
@Table(name = "Login")
public class Login {
	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(
			name = "login_sequence",
			sequenceName = "login_sequence",
			allocationSize = 1 //increment by 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator =  "login_sequence"
	)
	private Long id;

	private String loginID;
	private String employeeID;
	private String password;

	public Login() {
	}

	public Login(String loginID, String employeeID, String password) {
		this.loginID = loginID;
		this.employeeID = employeeID;
		this.password = password;
	}

public Long getId() {
		return id;
	}

public void setId(Long id) {
		this.id = id;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public void setPassword(String password) {
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

	@Override
	public String toString(){
		return "Login{" + "Id: "+ id + ", Client Name: " +loginID +", EmployeeId: "+ employeeID+", Password: "+ password+"}";
	}
}

