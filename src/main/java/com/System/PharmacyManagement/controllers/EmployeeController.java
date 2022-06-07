package com.System.PharmacyManagement.controllers;


import com.System.PharmacyManagement.models.Employee;
import com.System.PharmacyManagement.models.ResponseObject;
import com.System.PharmacyManagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Employees")

    //HTTP://localhost:8080/api/v1/Employees
public class EmployeeController {
    //DI = Dependency Injection
    @Autowired
    private EmployeeRepository repository;


    @GetMapping("")
    List<Employee> getAllEmployees() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Employee> foundEmployee = repository.findById(id);
        if (foundEmployee.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query employee successfully", foundEmployee)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find employee with id= " + id, "")
            );
        }
    }

    //Insert new Employee with POST method
    @PostMapping("/insertEmployee")
    ResponseEntity<ResponseObject> insertEmployee(@RequestBody Employee newEmployee) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert employee Successfully", repository.save(newEmployee))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkEmployee(@RequestBody Employee newEmployee) { //Check if employeeID is duplicate or not
        List<Employee> foundEmployee = repository.findByemployeeID(newEmployee.getEmployeeID().trim()
        );
        if (foundEmployee.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Employee name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert employee Successfully", repository.save(newEmployee))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        Employee updatedEmployee = repository.findById(id).map(employee -> {
            employee.setEmployeeID(newEmployee.getEmployeeID());
            employee.setDrugStoreID(newEmployee.getDrugStoreID());
            employee.setManagerID(newEmployee.getManagerBy());
            employee.setName(newEmployee.getName());
            employee.setEmail(newEmployee.getEmail());
            employee.setPhone(newEmployee.getPhone());
            employee.setPermission(newEmployee.getPermission());
            employee.setSalary(newEmployee.getSalary());
            return repository.save(newEmployee);
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update employee Successfully", updatedEmployee)
        );
    }

    //Delete a Employee => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteEmployee(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete employee successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find employee to DELETE", "")
        );
    }
}