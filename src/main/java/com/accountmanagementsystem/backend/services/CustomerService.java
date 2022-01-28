package com.accountmanagementsystem.backend.services;

import com.accountmanagementsystem.backend.entities.Customer;
import com.accountmanagementsystem.backend.exceptions.InvalidCustomerException;
import com.accountmanagementsystem.backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(int customerId) throws InvalidCustomerException {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(!optionalCustomer.isPresent()) {
            throw new InvalidCustomerException("Customer id not found : "+customerId);
        }
        return optionalCustomer.get();
    }

    public Customer findByPan(int pan) throws InvalidCustomerException {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepository.findCustomerByPan(pan));
        if(!optionalCustomer.isPresent()) {
            throw new InvalidCustomerException("Customer PAN not found : "+pan);
        }
        return optionalCustomer.get();
    }
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer update(Customer customer) throws InvalidCustomerException {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
        if(!optionalCustomer.isPresent()) {
            throw new InvalidCustomerException("Customer not existing to edit with id: "+customer.getCustomerId());
        }
        return customerRepository.save(customer);
    }
    public Customer delete(int customerId) throws InvalidCustomerException {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(!optionalCustomer.isPresent()) {
            throw new InvalidCustomerException("Customer not existing to delete with id: "+customerId);
        }
        Customer customer = optionalCustomer.get();
        customerRepository.deleteById(customerId);
        return customer;
    }
}
