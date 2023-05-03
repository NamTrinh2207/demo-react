package com.example.demoaxios.controller;

import com.example.demoaxios.model.Customers;
import com.example.demoaxios.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomer() {
        return new ResponseEntity<>((List<Customers>) customerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customers> save(@RequestBody Customers customers) {
        return new ResponseEntity<>(customerService.save(customers), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customers> update(@PathVariable long id, @RequestBody Customers customers) {
        Optional<Customers> customersOptional = customerService.findById(id);
        if (customersOptional.isPresent()) {
            customers.setId(id);
            return new ResponseEntity<>(customerService.save(customers), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customers> delete(@PathVariable long id) {
        Optional<Customers> customersOptional = customerService.findById(id);
        if (customersOptional.isPresent()) {
            customerService.remote(id);
            return new ResponseEntity<>(customersOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/views/{id}")
    public ResponseEntity<Customers> viewDetail(@PathVariable long id) {
        Optional<Customers> customersOptional = customerService.findById(id);
        return customersOptional.map(customers
                -> new ResponseEntity<>(customers, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
