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
    private String id;
    //@Column(nullable = false)
    private String name;
    //@Column(nullable = false)
    private String email;
    //@Column(nullable = false)
    private String phone;
    //@Column(nullable = false)
    private int permission;
    private int salary;

    @OneToMany(mappedBy = "id")
    private List<Client> clientList;


    @ManyToOne
    @JoinColumn(name = "drugStore",nullable = false)
    private DrugStore drugStore;


    @OneToOne
    @JoinColumn(name="managerID")
    private Manager manager;

    @OneToOne(mappedBy = "employee")
    private Login login;

    public Employee(String id, String name, String email, String phone, int permission, int salary, Manager manager) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.permission = permission;
        this.salary = salary;
        this.manager = manager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
