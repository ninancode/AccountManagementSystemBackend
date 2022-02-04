package com.accountmanagementsystem.backend.services;

import com.accountmanagementsystem.backend.entities.BankAccount;
import com.accountmanagementsystem.backend.exceptions.InvalidBankAccountException;
import com.accountmanagementsystem.backend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {
    BankAccountRepository bankAccountRepository;

    public BankAccountRepository getBankAccountRepository() {
        return bankAccountRepository;
    }
    @Autowired
    public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount findById(int accountId) throws InvalidBankAccountException {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
        if(!optionalBankAccount.isPresent()) {
            throw new InvalidBankAccountException("Bank account id/PAN not found : "+accountId);
        }
        return optionalBankAccount.get();
    }

    public List<BankAccount> findByPAN(int pan) throws InvalidBankAccountException {
        List<BankAccount> optionalBankAccounts = bankAccountRepository.findBankAccountsByPan(pan);
        if(!optionalBankAccounts.isEmpty()) {
            throw new InvalidBankAccountException("Customer PAN not found : "+pan);
        }
        return optionalBankAccounts;
    }

    public List<BankAccount> findAll(){
        return bankAccountRepository.findAll();
    }
    public BankAccount save(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }
    public BankAccount update(BankAccount bankAccount) throws InvalidBankAccountException {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(bankAccount.getAccountId());
        if(!optionalBankAccount.isPresent()) {
            throw new InvalidBankAccountException("Bank account not existing to edit with id: "+bankAccount.getAccountId());
        }
        return bankAccountRepository.save(bankAccount);
    }
    public BankAccount delete(int accountId) throws InvalidBankAccountException {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
        if(!optionalBankAccount.isPresent()) {
            throw new InvalidBankAccountException("Bank account not existing to delete with id: "+accountId);
        }
        BankAccount bankAccount = optionalBankAccount.get();
        bankAccountRepository.deleteById(accountId);
        return bankAccount;
    }
}
