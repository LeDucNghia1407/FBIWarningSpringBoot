package com.System.PharmacyManagement.models;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Client {



    @Id
    //This is "primary key"
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "client_sequence"
    )
    @Column(name = "id", nullable = false)
    private long id;


    @ManyToOne
    @JoinColumn(name = "employeeID", nullable = true)
    private Employee employee;





    public Client(long id, Employee employee) {
        this.id = id;
        this.employee = employee;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
