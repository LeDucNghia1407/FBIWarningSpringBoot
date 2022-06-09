package com.javatechie.jpa.controller;


import com.javatechie.jpa.entity.ResponseObject;
import com.javatechie.jpa.entity.Login;
import com.javatechie.jpa.repository.LoginRepository;
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
    List<Login> getAllLogins() {
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
                    new ResponseObject("ok", "Query Login successfully", foundLogin)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find Login with id= " + id, "")
            );
        }
    }

    //Insert new Login with POST method
    @PostMapping("/insertLogin")
    ResponseEntity<ResponseObject> insertLogin(@RequestBody Login newLogin) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Login Successfully", repository.save(newLogin))
        );
    }

   @PostMapping("/insert")
   ResponseEntity<ResponseObject> checkLogin(@RequestBody Login newLogin) { //Check if LoginID is duplicate or not
       List<Login> foundLogin = repository.findByid(newLogin.getId().trim());
       if (foundLogin.size() > 0) {
           return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                   new ResponseObject("failed", "Login name already taken", "")
           );
       }
       return ResponseEntity.status(HttpStatus.OK).body(
               new ResponseObject("ok", "Insert Login Successfully", repository.save(newLogin))
       );
   }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateLogin(@RequestBody Login newLogin, @PathVariable String id) {
        Login updatedLogin = repository.findById(id).map(login -> {
            login.setId(newLogin.getId());
            login.setEmployee(newLogin.getEmployee());
            login.setPassword(newLogin.getPassword());
            return repository.save(newLogin);
        }).orElseGet(() -> {
            newLogin.setId(id);
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
                    new ResponseObject("ok", "Delete Login successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find Login to DELETE", "")
        );
    }
}

