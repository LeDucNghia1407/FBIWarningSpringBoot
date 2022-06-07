package com.System.PharmacyManagement.controllers;



import com.System.PharmacyManagement.models.Manager;
import com.System.PharmacyManagement.models.ResponseObject;
import com.System.PharmacyManagement.repositories.ManagerRepository;
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
    List<Manager> getAllManager() {
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
                    new ResponseObject("ok", "Query manager successfully", foundManager)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find manager with id= " + id, "")
            );
        }
    }

    //Insert new Manager with POST method
    @PostMapping("/insertManager")
    ResponseEntity<ResponseObject> insertManager(@RequestBody Manager newManager) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert login Successfully", repository.save(newManager))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkManager(@RequestBody Manager newManager) { //Check if managerID is duplicate or not
        List<Manager> foundManager = repository.findBymanagerID(newManager.getManagerID().trim()
        );
        if (foundManager.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Manager name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert manager Successfully", repository.save(newManager))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateManager(@RequestBody Manager newManager, @PathVariable Long id) {
        Manager updatedManger = repository.findById(id).map(manager -> {
            manager.setManagerID(newManager.getManagerID());
            manager.setDrugStoreID(newManager.getDrugStoreID());
            return repository.save(newManager);
        }).orElseGet(() -> {
            newManager.setId(id);
            return repository.save(newManager);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update manager Successfully", updatedManger)
        );
    }

    //Delete a Manager => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteManager(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete manager successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find manager to DELETE", "")
        );
    }
}