package com.accountmanagementsystem.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    Integer id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    String password;
    int roleId;

    public User(String password, int roleId) {
        this.password = password;
        this.roleId = roleId;
    }
}
