package com.accountmanagementsystem.backend.controller;

import com.accountmanagementsystem.backend.entities.Customer;
import com.accountmanagementsystem.backend.exceptions.InvalidCustomerException;
import com.accountmanagementsystem.backend.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> findCustomer(@PathVariable int customerId) throws InvalidCustomerException {
        Customer customer = customerService.findById(customerId);
        ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customer, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/pan/{pan}")
    public ResponseEntity<Customer> findCustomerByPan(@PathVariable int pan) throws InvalidCustomerException {
        Customer customer = customerService.findByPan(pan);
        ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customer, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping()
    public List<Customer> findAll() {
        return this.customerService.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        Customer customerSave = customerService.save(customer);
        ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customerSave, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @PutMapping()
    public ResponseEntity<Customer> update (@RequestBody Customer customer) throws InvalidCustomerException {
        Customer customerUpdate = customerService.update(customer) ;
        ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customerUpdate, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Customer> delete(@PathVariable int customerId) throws InvalidCustomerException {
        Customer customer = customerService.delete(customerId);
        ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customer, HttpStatus.OK);
        return responseEntity;
    }
}
