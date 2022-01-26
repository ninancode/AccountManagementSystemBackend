package com.accountmanagementsystem.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {
    @Id
    Integer accountId;
    double currBalance;
    int customerId;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "customerId", nullable = false)
//    Customer customer;

    public BankAccount(int customerId, double currBalance) {
        this.customerId = customerId;
        this.currBalance = currBalance;
    }
}
