package com.accountmanagementsystem.backend.repositories;

import com.accountmanagementsystem.backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerByPan(int pan);
}
