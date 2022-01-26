package com.accountmanagementsystem.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    int id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    String password;
    int roleId;

    public User(String password, int roleId) {
        this.password = password;
        this.roleId = roleId;
    }
}
