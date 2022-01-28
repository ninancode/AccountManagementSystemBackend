package com.accountmanagementsystem.backend.services;

import com.accountmanagementsystem.backend.entities.Transaction;
import com.accountmanagementsystem.backend.exceptions.InvalidTransactionException;
import com.accountmanagementsystem.backend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    TransactionRepository transactionRepository;

    public TransactionRepository getTransactionRepository() {
        return transactionRepository;
    }
    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction findById(int transactionId) throws InvalidTransactionException {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
        if(!optionalTransaction.isPresent()) {
            throw new InvalidTransactionException("Transaction id not found : "+transactionId);
        }
        return optionalTransaction.get();
    }

    public List<Transaction> findByTransactionRef(int transactionRef) throws InvalidTransactionException {
        List<Transaction> optionalTransactions = transactionRepository.findTransactionsByTransactionRef(transactionRef);
        if(!optionalTransactions.isEmpty()) {
            throw new InvalidTransactionException("Transaction reference number not found : "+transactionRef);
        }
        return optionalTransactions;
    }
    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    public Transaction update(Transaction transaction) throws InvalidTransactionException {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transaction.getTransactionId());
        if(!optionalTransaction.isPresent()) {
            throw new InvalidTransactionException("Transaction not existing to edit with id: "+transaction.getTransactionId());
        }
        return transactionRepository.save(transaction);
    }
    public Transaction delete(int transactionId) throws InvalidTransactionException {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
        if(!optionalTransaction.isPresent()) {
            throw new InvalidTransactionException("Transaction not existing to delete with id: "+transactionId);
        }
        Transaction transaction = optionalTransaction.get();
        transactionRepository.deleteById(transactionId);
        return transaction;
    }
}
