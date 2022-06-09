package com.javatechie.jpa.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Login {

    @Id
    private String id;
    private String password;

    @OneToOne
    @JoinColumn(name = "employeeID", nullable = false)
    private Employee employee;

    public Login(String id, String password, Employee employee) {
        this.id = id;
        this.password = password;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
