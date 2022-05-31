package com.System.PharmacyManagement.controller;


import com.System.PharmacyManagement.models.ResponseObject;
import com.System.PharmacyManagement.repositories.ClientRepository;
import com.System.PharmacyManagement.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Controller")
public class AppController{
    //Dependencies Injection
    @Autowired
    private ClientRepository repository;

    @GetMapping("")
    //Return No data message when there is no data
    List<Client> getAllClient() {
        return repository.findAll();
    }
    //get detail Client
    @GetMapping("/{id}")
    //Let's return an object with data, message, status
    ResponseEntity<ResponseObject> findByID(@PathVariable Long id) {
        Optional<Client> foundClient = repository.findById(id);
        if (foundClient.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query about Client Successful", foundClient)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find Client with ID = " + id, "")
            );
        }
    }
    //Insert new Client with POST method
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertClient(@RequestBody Client newClient) {
            List<Client> foundClients = repository.findByClientName(newClient.getClientID().trim());
            if(foundClients.size() > 0) {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Client Name already exist", "")
                );
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Insert Client Successfully", repository.save(newClient))
            );
    }
    //Delete a Client => DELETE method
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteClient(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find client to delete", "")
        );
    }
}
