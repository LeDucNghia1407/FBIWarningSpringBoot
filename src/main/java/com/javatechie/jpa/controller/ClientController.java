package com.javatechie.jpa.controller;


import com.javatechie.jpa.entity.ResponseObject;
import com.javatechie.jpa.entity.Client;
import com.javatechie.jpa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Clients")

//HTTP://localhost:8080/api/v1/Clients
public class ClientController {
    //DI = Dependency Injection
    @Autowired
    private ClientRepository repository;


    @GetMapping("")
    List<Client> getAllClients() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable String id) {
        Optional<Client> foundClient = repository.findById(id);
        if (foundClient.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query client successfully", foundClient)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find client with id= " + id, "")
            );
        }
    }

    //Insert new Client with POST method
    @PostMapping("/insertClient")
    ResponseEntity<ResponseObject> insertClient(@RequestBody Client newClient) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Client Successfully", repository.save(newClient))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkClient(@RequestBody Client newClient) { //Check if clientID is duplicate or not
        List<Client> foundClient = repository.findByid(newClient.getId().trim()
        );
        if (foundClient.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Client name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Client Successfully", repository.save(newClient))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateClient(@RequestBody Client newClient, @PathVariable String id) {
        Client updatedClient = repository.findById(id).map(client -> {
            client.setId(newClient.getId());
            client.setEmployee(newClient.getEmployee());
            return repository.save(client);
        }).orElseGet(() -> {
            newClient.setId(id);
            return repository.save(newClient);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update Client Successfully", updatedClient)
        );
    }

    //Delete a Client => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteClient(@PathVariable String id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete client successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find client to DELETE", "")
        );
    }
}

