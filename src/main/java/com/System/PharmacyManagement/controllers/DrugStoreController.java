package com.System.PharmacyManagement.controllers;

import com.System.PharmacyManagement.models.*;
import com.System.PharmacyManagement.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/DrugStores")

//HTTP://localhost:8080/api/v1/DrugStores
public class DrugStoreController {
    //DI = Dependency Injection
    @Autowired
    private DrugStoreRepository repository;


    @GetMapping("")
    List<DrugStore> getAllDrugStores() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<DrugStore> foundDrugStore = repository.findById(id);
        if (foundDrugStore.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query DrugStore successfully", foundDrugStore)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find DrugStore with id= " + id, "")
            );
        }
    }

    //Insert new DrugStore with POST method
    @PostMapping("/insertDrugStore")
    ResponseEntity<ResponseObject> insertDrugStore(@RequestBody DrugStore newDrugStore) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert DrugStore Successfully", repository.save(newDrugStore))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkDrugStore(@RequestBody DrugStore newDrugStore) { //Check if DrugStoreID is duplicate or not
        List<DrugStore> foundDrugStore = repository.findByid(newDrugStore.getId());
        if (foundDrugStore.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "DrugStore name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert DrugStore Successfully", repository.save(newDrugStore))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateDrugStore(@RequestBody DrugStore newDrugStore, @PathVariable Long id) {
        DrugStore updatedDrugStore = repository.findById(id).map(DrugStore -> {
            DrugStore.setId(newDrugStore.getId());
            DrugStore.setDrugSupplier(newDrugStore.getDrugSupplier());
            DrugStore.setName(newDrugStore.getName());
            DrugStore.setAddress(newDrugStore.getAddress());
            return repository.save(DrugStore);
        }).orElseGet(() -> {
            newDrugStore.setId(id);
            return repository.save(newDrugStore);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update DrugStore Successfully", updatedDrugStore)
        );
    }

    //Delete a DrugStore => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteDrugStore(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete DrugStore successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find DrugStore to DELETE", "")
        );
    }
}

