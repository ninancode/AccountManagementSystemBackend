package com.accountmanagementsystem;

import com.accountmanagementsystem.backend.controller.RoleController;
import com.accountmanagementsystem.backend.controller.UserController;
import com.accountmanagementsystem.backend.entities.Role;
import com.accountmanagementsystem.backend.entities.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

@SpringBootApplication
public class AccountManagementSystemApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AccountManagementSystemApplication.class, args);
        //Add Roles
        RoleController roleController = ctx.getBean(RoleController.class);
        ResponseEntity<Role> managerRole = roleController.save(new Role(1, "Manager"));
        System.out.println(managerRole);
        ResponseEntity<Role> customerRole = roleController.save(new Role(2, "Customer"));
        System.out.println(customerRole);
        //Add Manager
        UserController userController = ctx.getBean(UserController.class);
        ResponseEntity<User> managerUser = userController.save(new User(101, "pass", 1));
        System.out.println(managerUser);
        //Add User
        ResponseEntity<User> customerUser = userController.save(new User(102, "pass", 2));
        System.out.println(customerUser);

    }


}
