package com.javatechie.jpa.controller;

import com.javatechie.jpa.entity.ResponseObject;
import com.javatechie.jpa.entity.Drug;
import com.javatechie.jpa.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Drugs")

//HTTP://localhost:8080/api/v1/drugs
public class DrugController {
    //DI = Dependency Injection
    @Autowired
    private DrugRepository repository;


    @GetMapping("")
    List<Drug> getAlldrugs() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable String id) {
        Optional<Drug> founddrug = repository.findById(id);
        if (founddrug.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query drug successfully", founddrug)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find drug with id= " + id, "")
            );
        }
    }

    //Insert new drug with POST method
    @PostMapping("/insertdrug")
    ResponseEntity<ResponseObject> insertdrug(@RequestBody Drug newdrug) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert drug Successfully", repository.save(newdrug))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkDrug(@RequestBody Drug newDrug) { //Check if drugID is duplicate or not
        List<Drug> foundDrug = repository.findByid(newDrug.getId().trim());
        if (foundDrug.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Drug name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert drug Successfully", repository.save(newDrug))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateDrug(@RequestBody Drug newDrug, @PathVariable String id) {
        Drug updatedDrug = repository.findById(id).map(drug -> {
            drug.setId(newDrug.getId());
            drug.setDrugSupplier(newDrug.getDrugSupplier());
            drug.setDrugName(newDrug.getDrugName());
            drug.setManufacturingDate(newDrug.getManufacturingDate());
            drug.setExpiredDate(newDrug.getExpiredDate());
            drug.setType(newDrug.getType());
            drug.setPrice(newDrug.getPrice());
            return repository.save(drug);
        }).orElseGet(() -> {
            newDrug.setId(id);
            return repository.save(newDrug);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update drug Successfully", updatedDrug)
        );
    }

    //Delete a drug => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deletedrug(@PathVariable String id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete drug successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find drug to DELETE", "")
        );
    }
}

