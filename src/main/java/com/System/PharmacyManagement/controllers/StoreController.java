package com.System.PharmacyManagement.controllers;



import com.System.PharmacyManagement.models.Store;
import com.System.PharmacyManagement.models.ResponseObject;
import com.System.PharmacyManagement.repositories.StoreRepository;
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
    List<Store> getAllStore() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Store> foundOrder = repository.findById(id);
        if (foundOrder.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query store successfully", foundOrder)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find store with id= " + id, "")
            );
        }
    }

    //Insert new Store with POST method
    @PostMapping("/insertStore")
    ResponseEntity<ResponseObject> insertStore(@RequestBody Store newStore) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert store Successfully", repository.save(newStore))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkStore(@RequestBody Store newStore) { //Check if storeID is duplicate or not
        List<Store> foundStore = repository.findBystoreID(newStore.getStoreID().trim()
        );
        if (foundStore.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "store name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert store Successfully", repository.save(newStore))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateStore(@RequestBody Store newStore, @PathVariable Long id) {
        Store updatedStore = repository.findById(id).map(store -> {
            store.setStoreID(newStore.getStoreID());
            store.setDrugID(newStore.getdrugID());
            store.setStoreID(newStore.getdrugStoreID());
            store.setStoreTime(newStore.getStoreTime());
            store.setQuantity(newStore.getQuantity());
            return repository.save(newStore);
        }).orElseGet(() -> {
            newStore.setId(id);
            return repository.save(newStore);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update store Successfully", updatedStore)
        );
    }

    //Delete a Store => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteStore(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete store successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find store to DELETE", "")
        );
    }
}