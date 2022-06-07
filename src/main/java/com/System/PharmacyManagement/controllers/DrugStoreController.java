package com.System.PharmacyManagement.controllers;


import com.System.PharmacyManagement.models.DrugStore;
import com.System.PharmacyManagement.models.ResponseObject;
import com.System.PharmacyManagement.repositories.DrugRepository;
import com.System.PharmacyManagement.repositories.DrugStoreRepository;
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
    ResponseEntity<ResponseObject> findById(@PathVariable String id) {
        Optional<DrugStore> foundDrugStore = repository.findById(id);
        if (foundDrugStore.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query drug store successfully", foundDrugStore)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find drug store with id= " + id, "")
            );
        }
    }

    //Insert new Drug Store with POST method
    @PostMapping("/insertDrugStore")
    ResponseEntity<ResponseObject> insertDrugStore(@RequestBody DrugStore newDrug) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert drug store Successfully", repository.save(newDrug))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkDrugStore(@RequestBody DrugStore newDrug) { //Check if clientID is duplicate or not
        List<DrugStore> foundDrugStore = repository.findBydrugStoreID(newDrug.getDrugStoreID().trim()
        );
        if (foundDrugStore.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Drug store name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert drug store Successfully", repository.save(newDrug))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateDrugStore(@RequestBody DrugStore newDrugStore, @PathVariable String id) {
        DrugStore updatedDrugStore = repository.findById(id).map(drugStore -> {
            drugStore.setDrugStoreID(newDrugStore.getDrugStoreID());
            drugStore.setDrugSupplierID(newDrugStore.getDrugSupplierID());
            drugStore.setName(newDrugStore.getName());
            drugStore.setAddress(newDrugStore.getAddress());
            return repository.save(drugStore);
        }).orElseGet(() -> {
            newDrugStore.setDrugStoreID(id);
            return repository.save(newDrugStore);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update drug store Successfully", updatedDrugStore)
        );
    }

    //Delete a Drug Store => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteDrugStore(@PathVariable String id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete drug store successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find drug store to DELETE", "")
        );
    }
}