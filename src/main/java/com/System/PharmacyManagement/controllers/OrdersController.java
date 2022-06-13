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
@RequestMapping(path = "/api/v1/Orderss")

//HTTP://localhost:8080/api/v1/Orderss
public class OrdersController {
    //DI = Dependency Injection
    @Autowired
    private OrdersRepository repository;


    @GetMapping("")
    List<Orders> getAllOrderss() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Orders> foundOrders = repository.findById(id);
        if (foundOrders.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query Orders successfully", foundOrders)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find Orders with id= " + id, "")
            );
        }
    }

    //Insert new Orders with POST method
    @PostMapping("/insertOrders")
    ResponseEntity<ResponseObject> insertOrders(@RequestBody Orders newOrders) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Orders Successfully", repository.save(newOrders))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkOrders(@RequestBody Orders newOrders) { //Check if OrdersID is duplicate or not
        List<Orders> foundOrders = repository.findByid(newOrders.getId());
        if (foundOrders.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Orders name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Orders Successfully", repository.save(newOrders))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateOrders(@RequestBody Orders newOrders, @PathVariable Long id) {
        Orders updatedOrders = repository.findById(id).map(Orders -> {
            Orders.setId(newOrders.getId());
            Orders.setDrugQuantity(newOrders.getDrugQuantity());
            Orders.setTime(newOrders.getTime());
            Orders.setDrugQuantity(newOrders.getDrugQuantity());
            Orders.setClient(newOrders.getClient());

            return repository.save(newOrders);
        }).orElseGet(() -> {
            newOrders.setId(id);
            return repository.save(newOrders);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update Orders Successfully", updatedOrders)
        );
    }

    //Delete a Orders => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteOrders(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Orders successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find Orders to DELETE", "")
        );
    }
}

