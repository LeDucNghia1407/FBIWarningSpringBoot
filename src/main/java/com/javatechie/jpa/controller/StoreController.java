package com.javatechie.jpa.controller;


import com.javatechie.jpa.entity.ResponseObject;
import com.javatechie.jpa.entity.Store;
import com.javatechie.jpa.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Stores")

//HTTP://localhost:8080/api/v1/Stores
public class StoreController {
    //DI = Dependency Injection
    @Autowired
    private StoreRepository repository;


    @GetMapping("")
    List<Store> getAllStores() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Store> foundStore = repository.findById(id);
        if (foundStore.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query Store successfully", foundStore)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find Store with id= " + id, "")
            );
        }
    }

    //Insert new Store with POST method
    @PostMapping("/insertStore")
    ResponseEntity<ResponseObject> insertStore(@RequestBody Store newStore) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Store Successfully", repository.save(newStore))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkStore(@RequestBody Store newStore) { //Check if StoreID is duplicate or not
        List<Store> foundStore = repository.findByid(newStore.getId());
        if (foundStore.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Store name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Store Successfully", repository.save(newStore))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateStore(@RequestBody Store newStore, @PathVariable Long id) {
        Store updatedStore = repository.findById(id).map(Store -> {
            Store.setId(newStore.getId());
            Store.setDrugQuantity(newStore.getDrugQuantity());
            Store.setStoreTime(newStore.getStoreTime());
            Store.setDrugStore(newStore.getDrugStore());
            Store.setDrug(newStore.getDrug());


            return repository.save(newStore);
        }).orElseGet(() -> {
            newStore.setId(id);
            return repository.save(newStore);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update Store Successfully", updatedStore)
        );
    }

    //Delete a Store => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteStore(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Store successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find Store to DELETE", "")
        );
    }
}

