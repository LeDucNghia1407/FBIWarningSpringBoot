
package com.System.PharmacyManagement.controllers;


import com.System.PharmacyManagement.models.*;
import com.System.PharmacyManagement.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Invoices")

//HTTP://localhost:8080/api/v1/Invoices
public class InvoiceController {
    //DI = Dependency Injection
    @Autowired
    private InvoiceRepository repository;


    @GetMapping("")
    List<Invoice> getAllInvoices() {
        return repository.findAll();
        //Using H2 Database to store data locally
        //Send Request Using Postman
    }

    @GetMapping("/getnum")
    public List<InvoiceMethod> getbyInvoice()
    {
        return repository.getInvoiceMethod();
    }
    @GetMapping("/getnum/{num}")
    public List<InvoiceMethod> getbyInvoiceno(@PathVariable("num") int num)
    {
        return repository.getInvoiceMethodbyNum(num);
    }

    @GetMapping("/getQuantityandPrice")
    public List<InvoiceTotal> getbyInvoiceInfo()
    {
        return repository.getJoinInformation();
    }

    @GetMapping("/{id}")
        //Let's return an Object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Invoice> foundInvoice = repository.findById(id);
        if (foundInvoice.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query Invoice successfully", foundInvoice)
                    //You can replace "ok" with your defined "error code"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find Invoice with id= " + id, "")
            );
        }
    }



    @GetMapping("/getQuantityandPrice/{num}")
    public List<InvoiceTotal> getbyNo(@PathVariable("num") int num){
        return repository.getJoinInformationbynum(num);
    }

    //Insert new Invoice with POST method
    @PostMapping("/insertInvoice")
    ResponseEntity<ResponseObject> insertInvoice(@RequestBody Invoice newInvoice) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Invoice Successfully", repository.save(newInvoice))
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> checkInvoice(@RequestBody Invoice newInvoice) { //Check if InvoiceID is duplicate or not
        List<Invoice> foundInvoice = repository.findByid((newInvoice.getId()));
        if (foundInvoice.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Invoice name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Invoice Successfully", repository.save(newInvoice))
        );
    }

    //Update, Upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateInvoice(@RequestBody Invoice newInvoice, @PathVariable Long id) {
        Invoice updatedInvoice = repository.findById(id).map(Invoice -> {
            Invoice.setId(newInvoice.getId());
            Invoice.setDrug(newInvoice.getDrug());
            Invoice.setNo(newInvoice.getNo());
            Invoice.setQuantity(newInvoice.getQuantity());
            return repository.save(newInvoice);
        }).orElseGet(() -> {
            newInvoice.setId(id);
            return repository.save(newInvoice);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update Invoice Successfully", updatedInvoice)
        );
    }

    //Delete a Invoice => DELETE method
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteInvoice(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Invoice successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find Invoice to DELETE", "")
        );
    }
}

