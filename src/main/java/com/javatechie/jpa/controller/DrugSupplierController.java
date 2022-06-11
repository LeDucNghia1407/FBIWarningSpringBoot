package com.javatechie.jpa.controller;


import com.javatechie.jpa.entity.ResponseObject;
import com.javatechie.jpa.entity.DrugSupplier;
import com.javatechie.jpa.repository.DrugSupplierRepository;
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
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<DrugSupplier> foundDrugSupplier = repository.findById(id);
        if (foundDrugSupplier.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query DrugSupplier successfully", foundDrugSupplier)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find DrugSupplier with id= " + id, "")
            );
        }
    }

    //Insert new DrugSupplier with POST method
    @PostMapping("/insertDrugSupplier")
    ResponseEntity<ResponseObject> insertDrugSupplier(@RequestBody DrugSupplier newDrugSupplier) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert DrugSupplier Successfully", repository.save(newDrugSupplier))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkDrugSupplier(@RequestBody DrugSupplier newDrugSupplier) { //Check if DrugSupplierID is duplicate or not
        List<DrugSupplier> foundDrugSupplier = repository.findByid(newDrugSupplier.getId().longValue());
        if (foundDrugSupplier.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "DrugSupplier name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert DrugSupplier Successfully", repository.save(newDrugSupplier))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateDrugSupplier(@RequestBody DrugSupplier newDrugSupplier, @PathVariable Long id) {
        DrugSupplier updatedDrugSupplier = repository.findById(id).map(DrugSupplier -> {
            DrugSupplier.setId(newDrugSupplier.getId());
            DrugSupplier.setName(newDrugSupplier.getName());
            DrugSupplier.setAddress(newDrugSupplier.getAddress());
            return repository.save(DrugSupplier);
        }).orElseGet(() -> {
            newDrugSupplier.setId(id);
            return repository.save(newDrugSupplier);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update DrugSupplier Successfully", updatedDrugSupplier)
        );
    }

    //Delete a DrugSupplier => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteDrugSupplier(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete DrugSupplier successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find DrugSupplier to DELETE", "")
        );
    }
}

