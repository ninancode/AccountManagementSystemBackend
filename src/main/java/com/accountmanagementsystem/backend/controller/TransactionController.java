package com.accountmanagementsystem.backend.controller;

import com.accountmanagementsystem.backend.entities.Transaction;
import com.accountmanagementsystem.backend.exceptions.InvalidTransactionException;
import com.accountmanagementsystem.backend.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> findTransaction(@PathVariable int transactionId) throws InvalidTransactionException {
        Transaction transaction = transactionService.findById(transactionId);
        ResponseEntity<Transaction> responseEntity = new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{transactionRef}")
    public ResponseEntity<List<Transaction>> findByTransactionRef(@PathVariable int transactionRef) throws InvalidTransactionException {
        List<Transaction> transactions = transactionService.findByTransactionRef(transactionRef);
        ResponseEntity<List<Transaction>> responseEntity = new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping( )
    public List<Transaction> findAll() {
        return this.transactionService.findAll();
    }

    @PostMapping()
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction) {
        Transaction transactionSave = transactionService.save(transaction);
        ResponseEntity<Transaction> responseEntity = new ResponseEntity<Transaction>(transactionSave, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping()
    public ResponseEntity<Transaction> update (@RequestBody Transaction transaction) throws InvalidTransactionException {
        Transaction transactionUpdate = transactionService.update(transaction) ;
        ResponseEntity<Transaction> responseEntity = new ResponseEntity<Transaction>(transactionUpdate, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Transaction> delete(@PathVariable int transactionId) throws InvalidTransactionException {
        Transaction transaction = transactionService.delete(transactionId);
        ResponseEntity<Transaction> responseEntity = new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
        return responseEntity;
    }
}

