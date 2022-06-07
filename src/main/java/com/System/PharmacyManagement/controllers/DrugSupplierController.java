package com.System.PharmacyManagement.controllers;


import com.System.PharmacyManagement.models.DrugSupplier;
import com.System.PharmacyManagement.models.ResponseObject;
import com.System.PharmacyManagement.repositories.DrugSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/DrugSuppliers")

    //HTTP://localhost:8080/api/v1/DrugSuppliers
public class DrugSupplierController {
    //DI = Dependency Injection
    @Autowired
    private DrugSupplierRepository repository;


    @GetMapping("")
    List<DrugSupplier> getAllDrugSuppliers() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable String id) {
        Optional<DrugSupplier> foundDrugSupplier = repository.findById(id);
        if (foundDrugSupplier.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query drug supplier successfully", foundDrugSupplier)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find drug supplier with id= " + id, "")
            );
        }
    }

    //Insert new Drug Supplier with POST method
    @PostMapping("/insertDrugSupplier")
    ResponseEntity<ResponseObject> insertDrugSupplier(@RequestBody DrugSupplier newDrugSupplier) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert drug store Successfully", repository.save(newDrugSupplier))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkDrugSupplier(@RequestBody DrugSupplier newDrug) { //Check if Drug SupplierID is duplicate or not
        List<DrugSupplier> foundDrugSupplier = repository.findBydrugSupplierID(newDrug.getDrugSupplierID().trim()
        );
        if (foundDrugSupplier.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Drug supplier name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert drug supllier Successfully", repository.save(newDrug))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateDrugSupplier(@RequestBody DrugSupplier newDrugSupplier, @PathVariable String id) {
        DrugSupplier updatedDrugSupplier = repository.findById(id).map(drugSupplier -> {
            drugSupplier.setDrugSupplierID(newDrugSupplier.getDrugSupplierID());
            drugSupplier.setName(newDrugSupplier.getName());
            drugSupplier.setAddress(newDrugSupplier.getAddress());
            return repository.save(drugSupplier);
        }).orElseGet(() -> {
            newDrugSupplier.setDrugSupplierID(id);
            return repository.save(newDrugSupplier);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update drug supplier Successfully", updatedDrugSupplier)
        );
    }

    //Delete a DrugSupplier => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteDrugSupplier(@PathVariable String id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete drug supplier successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find drug supplier to DELETE", "")
        );
    }
}