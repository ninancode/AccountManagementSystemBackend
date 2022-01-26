package com.accountmanagementsystem.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Integer customerId;
    int pan;
    int uid;
    String name;
    int zipcode;
    String email;
    Date birthdate;

    public Customer(int pan, int uid, String name, int zipcode, String email, Date birthdate) {
        this.pan = pan;
        this.uid = uid;
        this.name = name;
        this.zipcode = zipcode;
        this.email = email;
        this.birthdate = birthdate;
    }
}
