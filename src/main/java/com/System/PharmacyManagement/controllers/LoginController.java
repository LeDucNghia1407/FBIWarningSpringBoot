package com.System.PharmacyManagement.controllers;



import com.System.PharmacyManagement.models.Login;
import com.System.PharmacyManagement.models.ResponseObject;
import com.System.PharmacyManagement.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Logins")

    //HTTP://localhost:8080/api/v1/Logins
public class LoginController {
    //DI = Dependency Injection
    @Autowired
    private LoginRepository repository;


    @GetMapping("")
    List<Login> getAllLogin() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable String id) {
        Optional<Login> foundLogin = repository.findById(id);
        if (foundLogin.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query login successfully", foundLogin)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find login with id= " + id, "")
            );
        }
    }

    //Insert new Login with POST method
    @PostMapping("/insertLogin")
    ResponseEntity<ResponseObject> insertLogin(@RequestBody Login newLogin) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert login Successfully", repository.save(newLogin))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkLogin(@RequestBody Login newLogin) { //Check if LoginID is duplicate or not
        List<Login> foundEmployee = repository.findByLoginID(newLogin.getLoginID().trim()
        );
        if (foundEmployee.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Login name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert login Successfully", repository.save(newLogin))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateLogin(@RequestBody Login newLogin, @PathVariable String id) {
        Login updatedLogin = repository.findById(id).map(login -> {
            login.setLoginID(newLogin.getLoginID());
            login.setEmployeeID(newLogin.getEmployeeID());
            login.setPassword(newLogin.getPassword());
            return repository.save(newLogin);
        }).orElseGet(() -> {
            newLogin.setLoginID(id);
            return repository.save(newLogin);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update login Successfully", updatedLogin)
        );
    }

    //Delete a Login => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteLogin(@PathVariable String id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete login successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find login to DELETE", "")
        );
    }
}