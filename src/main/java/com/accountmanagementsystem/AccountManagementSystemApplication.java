package com.accountmanagementsystem;

import com.accountmanagementsystem.backend.controller.*;
import com.accountmanagementsystem.backend.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.sql.Time;

@SpringBootApplication
public class AccountManagementSystemApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AccountManagementSystemApplication.class, args);
        //Add Roles
        RoleController roleController = ctx.getBean(RoleController.class);
        ResponseEntity<Role> managerRole = roleController.save(new Role(1, "Manager"));
        ResponseEntity<Role> customerRole = roleController.save(new Role(2, "Customer"));
        //Add Manager
        UserController userController = ctx.getBean(UserController.class);
        ResponseEntity<User> managerUser = userController.save(new User(101, "pass", 1));
        //Add User
        ResponseEntity<User> customerUser = userController.save(new User(102, "pass", 2));
        //Add Customer
        CustomerController customerController = ctx.getBean(CustomerController.class);
        ResponseEntity<Customer> customer102 = customerController.save(new Customer(102, 333, "John Doe", 53209, "johndoe@gmail.com", new Date(96, 9, 21)));
        //Add Accounts
        BankAccountController accountController = ctx.getBean(BankAccountController.class);
        ResponseEntity<BankAccount> userAccount1 = accountController.save(new BankAccount(2, 5000.00, 102));
        ResponseEntity<BankAccount> userAccount2 = accountController.save(new BankAccount(3, 1000.43, 102));
        ResponseEntity<BankAccount> userAccount3 = accountController.save(new BankAccount(4, 1000.99, 103));
        //Add Transactions
        TransactionController transactionController = ctx.getBean(TransactionController.class);
        ResponseEntity<Transaction> transaction2 = transactionController.save(new Transaction(5, 2, new Date(122,0,22), new Time(23,01,00), "Deposit", "Cash", 5000.00));
        ResponseEntity<Transaction> transaction3 = transactionController.save(new Transaction(6, 3, new Date(122,0,23), new Time(8,54,43), "Deposit", "Cash", 8080.00));
        ResponseEntity<Transaction> transaction4 = transactionController.save(new Transaction(7, 3, new Date(122,0,28), new Time(12,00,3), "Withdrawal", "Transfer", 3000.00));
        ResponseEntity<Transaction> transaction5 = transactionController.save(new Transaction(8, 3, new Date(122,0,29), new Time(15,237,10), "Withdrawal", "Transfer", 2895.90));
        ResponseEntity<Transaction> transaction6 = transactionController.save(new Transaction(9, 3, new Date(122,1,2), new Time(6,6,6), "Withdrawal", "Cash", 2094.33));
        ResponseEntity<Transaction> transaction7 = transactionController.save(new Transaction(3, new Date(122,1,3), new Time(23,01,00), "Withdrawal", "Cash", 1000.43));


        System.out.println(managerRole);
        System.out.println(customerRole);
        System.out.println(managerUser);
        System.out.println(customerUser);
        System.out.println(customer102);
        System.out.println(userAccount1);
        System.out.println(userAccount2);
        System.out.println(userAccount3);
        System.out.println(transaction2);
        System.out.println(transaction3);
        System.out.println(transaction4);
        System.out.println(transaction5);
        System.out.println(transaction6);
        System.out.println(transaction7);


    }


}
