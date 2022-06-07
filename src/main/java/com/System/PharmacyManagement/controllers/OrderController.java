package com.System.PharmacyManagement.controllers;



import com.System.PharmacyManagement.models.Orders;
import com.System.PharmacyManagement.models.ResponseObject;
import com.System.PharmacyManagement.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Orders")

    //HTTP://localhost:8080/api/v1/Orders
public class OrderController {
    //DI = Dependency Injection
    @Autowired
    private OrdersRepository repository;


    @GetMapping("")
    List<Orders> getAllManager() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Orders> foundOrder = repository.findById(id);
        if (foundOrder.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query order successfully", foundOrder)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find order with id= " + id, "")
            );
        }
    }

    //Insert new Order with POST method
    @PostMapping("/insertOrder")
    ResponseEntity<ResponseObject> insertOrder(@RequestBody Orders newOrders) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert order Successfully", repository.save(newOrders))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkOrder(@RequestBody Orders newOrders) { //Check if orderID is duplicate or not
        List<Orders> foundOrders = repository.findByorderID(newOrders.getOrderID().trim()
        );
        if (foundOrders.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Order name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert order Successfully", repository.save(newOrders))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateOrder(@RequestBody Orders newOrders, @PathVariable Long id) {
        Orders updatedOrders = repository.findById(id).map(order -> {
            order.setOrderID(newOrders.getOrderID());
            order.setDrugID(newOrders.getDrugID());
            order.setClientID(newOrders.getClientID());
            order.setTime(newOrders.getTime());
            order.setDrugQuantity(newOrders.getDrugQuantity());
            return repository.save(newOrders);
        }).orElseGet(() -> {
            newOrders.setId(id);
            return repository.save(newOrders);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update order Successfully", updatedOrders)
        );
    }

    //Delete a Order => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteOrder(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete order successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find order to DELETE", "")
        );
    }
}