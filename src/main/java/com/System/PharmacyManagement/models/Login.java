package com.System.PharmacyManagement.models;



import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
public class Login {

    @Id
    @SequenceGenerator(
            name = "login_sequence",
            sequenceName = "login_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "login_sequence"
    )
    @Column(name = "id", nullable = false)
    private long id;
    private String password;

    @OneToOne
    @JoinColumn(name = "employeeID", nullable = true)
    private Employee employee;
    public Login() {}
    public Login(long id, String password, Employee employee) {
        this.id = id;
        this.password = password;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
