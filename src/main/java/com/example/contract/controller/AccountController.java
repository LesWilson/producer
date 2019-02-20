package com.example.contract.controller;

import com.example.contract.model.Account;
import com.example.contract.repository.AccountRepository;
import com.example.contract.transfer.AccountUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AccountController {

    AccountRepository accountRepository;

    public AccountController(AccountRepository repository) {
        this.accountRepository = repository;
    }

    @PostMapping(value = "/accounts/{userId}")
    public ResponseEntity<Account> createAccount(@RequestBody @Valid Account account, @PathVariable Long userId) {

        account.setOwnerId(userId);
        Account savedAccount = accountRepository.save(account);

        return ResponseEntity
                .status(201)
                .body(savedAccount);
    }

    @PutMapping(value = "/accounts/{userId}/{accountId}")
    public ResponseEntity<Account> updateAccount(@RequestBody @Valid AccountUpdateDTO account, @PathVariable long userId, @PathVariable long accountId) {

        // retrieve the user from db
        Account existingAccount = accountRepository.findById(accountId).get();
        existingAccount.updateBalance(account.getAmount());

        existingAccount = accountRepository.save(existingAccount);

        return ResponseEntity
                .status(200)
                .body(existingAccount);
    }

    @GetMapping(value = "/accounts/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable long id) {

        Account account = accountRepository.findById(id).get();

        return ResponseEntity
                .status(200)
                .body(account);
    }


}
