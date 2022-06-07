package com.System.PharmacyManagement.models;



import javax.persistence.*;

@Entity
@Table(name = "Login")
public class Login {



	@Id
	private String loginID;
	@Column(name = "employeeID", nullable = false)
	private String employeeID;
	@Column(name = "password", nullable = false)
	private String password;

	public Login() {
	}

	public Login(String loginID, String employeeID, String password) {
		this.loginID = loginID;
		this.employeeID = employeeID;
		this.password = password;
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
		return "Login{"+ ", Client Name: " +loginID +", EmployeeId: "+ employeeID+", Password: "+ password+"}";
	}
}

