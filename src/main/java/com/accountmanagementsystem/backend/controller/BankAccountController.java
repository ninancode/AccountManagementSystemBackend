package com.accountmanagementsystem.backend.controller;

import com.accountmanagementsystem.backend.entities.BankAccount;
import com.accountmanagementsystem.backend.exceptions.InvalidBankAccountException;
import com.accountmanagementsystem.backend.services.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bankaccounts")
public class BankAccountController {
    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{accountId}")
    public ResponseEntity<BankAccount> findBankAccount(@PathVariable int accountId) throws InvalidBankAccountException {
        BankAccount bankAccount = bankAccountService.findById(accountId);
        ResponseEntity<BankAccount> responseEntity = new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{customerId}")
    public ResponseEntity<List<BankAccount>> findBankAccountByPan(@PathVariable int customerId) throws InvalidBankAccountException {
        List<BankAccount> bankAccounts = bankAccountService.findByCustomerId(customerId);
        ResponseEntity<List<BankAccount>> responseEntity = new ResponseEntity<List<BankAccount>>(bankAccounts, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping()
    public List<BankAccount> findAll() {
        return this.bankAccountService.findAll();
    }

    @PostMapping()
    public ResponseEntity<BankAccount> save(@RequestBody BankAccount customer) {
        BankAccount bankAccountSave = bankAccountService.save(customer);
        ResponseEntity<BankAccount> responseEntity = new ResponseEntity<BankAccount>(bankAccountSave, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping()
    public ResponseEntity<BankAccount> update (@RequestBody BankAccount bankAccount) throws InvalidBankAccountException {
        BankAccount bankAccountUpdate = bankAccountService.update(bankAccount) ;
        ResponseEntity<BankAccount> responseEntity = new ResponseEntity<BankAccount>(bankAccountUpdate, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<BankAccount> delete(@PathVariable int accountId) throws InvalidBankAccountException {
        BankAccount bankAccount = bankAccountService.delete(accountId);
        ResponseEntity<BankAccount> responseEntity = new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
        return responseEntity;
    }
}
