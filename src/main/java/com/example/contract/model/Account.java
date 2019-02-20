package com.example.contract.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String accountName;

    private double balance = 0;

    private Long ownerId;

    public double updateBalance(double amount) {
        this.balance += amount;
        return this .balance;
    }
}
