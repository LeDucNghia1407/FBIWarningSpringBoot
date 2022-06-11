package com.javatechie.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
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
    //@Column(nullable = false)
    private String name;
    //@Column(nullable = false)
    private String email;
    //@Column(nullable = false)
    private String phone;
    //@Column(nullable = false)
    private int permission;
    private int salary;



    @ManyToOne
    @JoinColumn(name = "drugStore",nullable = true)
    private DrugStore drugStore;


    @OneToOne
    @JoinColumn(name="managerID")
    private Manager manager;



    public Employee(Long id, String name, String email, String phone, int permission, int salary, Manager manager) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.permission = permission;
        this.salary = salary;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
