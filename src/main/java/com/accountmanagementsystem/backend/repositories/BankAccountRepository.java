package com.accountmanagementsystem.backend.repositories;

import com.accountmanagementsystem.backend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository <BankAccount, Integer> {
    List<BankAccount> findBankAccountsByCustomerId(int customerId);
}
