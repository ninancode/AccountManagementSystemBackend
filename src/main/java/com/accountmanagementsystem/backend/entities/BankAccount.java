package com.accountmanagementsystem.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer accountId;
    double currBalance;
    int pan;

    public BankAccount(double currBalance, int pan) {
        this.currBalance = currBalance;
        this.pan = pan;
    }
}
