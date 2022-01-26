package com.accountmanagementsystem.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer transactionId;
    int transactionRef;
    Date date;
    Time time;
    String type;
    String subtype;
    double currBalance;

    public Transaction(int transactionRef, Date date, Time time, String type, String subtype, double currBalance) {
        this.transactionRef = transactionRef;
        this.date = date;
        this.time = time;
        this.type = type;
        this.subtype = subtype;
        this.currBalance = currBalance;
    }
}
