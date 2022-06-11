package com.javatechie.jpa.controller;


import com.javatechie.jpa.entity.ResponseObject;
import com.javatechie.jpa.entity.Manager;
import com.javatechie.jpa.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Managers")

//HTTP://localhost:8080/api/v1/Managers
public class ManagerController {
    //DI = Dependency Injection
    @Autowired
    private ManagerRepository repository;


    @GetMapping("")
    List<Manager> getAllManagers() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Manager> foundManager = repository.findById(id);
        if (foundManager.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query Manager successfully", foundManager)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find Manager with id= " + id, "")
            );
        }
    }

    //Insert new Manager with POST method
    @PostMapping("/insertManager")
    ResponseEntity<ResponseObject> insertManager(@RequestBody Manager newManager) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Manager Successfully", repository.save(newManager))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkManager(@RequestBody Manager newManager) { //Check if ManagerID is duplicate or not
        List<Manager> foundManager = repository.findByid(newManager.getId().longValue());
        if (foundManager.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Manager name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Manager Successfully", repository.save(newManager))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateManager(@RequestBody Manager newManager, @PathVariable Long id) {
        Manager updatedManager = repository.findById(id).map(Manager -> {
            Manager.setId(newManager.getId());
            Manager.setDrugStore(newManager.getDrugStore());

            return repository.save(newManager);
        }).orElseGet(() -> {
            newManager.setId(id);
            return repository.save(newManager);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update Manager Successfully", updatedManager)
        );
    }

    //Delete a Manager => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteManager(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Manager successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find Manager to DELETE", "")
        );
    }
}

