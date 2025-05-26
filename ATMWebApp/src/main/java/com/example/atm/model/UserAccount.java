package com.example.atm.model;

import jakarta.persistence.*;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private int pin;
    private double balance;

    public UserAccount() {}

    public UserAccount(String cardNumber, int pin, double balance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
