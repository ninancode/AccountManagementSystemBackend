package com.accountmanagementsystem.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {
    @Id
    int accountId;
    int customerId;
    double currBalance;

    public BankAccount(int customerId, double currBalance) {
        this.customerId = customerId;
        this.currBalance = currBalance;
    }
}
