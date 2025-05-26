package com.example.atm.controller;


import com.example.atm.model.UserAccount;
import com.example.atm.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atm")
public class ATMController {

    @Autowired
    private ATMService service;

    // Login using PIN
    @PostMapping("/login")
    public UserAccount login(@RequestParam int pin) {
        return service.login(pin);
    }

    // Check balance by user ID
    @GetMapping("/{id}/balance")
    public String getBalance(@PathVariable Long id) {
        double balance = service.checkBalance(id);
        return (balance >= 0) ? "Current Balance: ₹" + balance : "User not found";
    }

    // Deposit amount
    @PostMapping("/{id}/deposit")
    public String deposit(@PathVariable Long id, @RequestParam double amount) {
        if (amount <= 0 || amount > 1_000_000_000) {
            return "Deposit failed: Amount must be greater than 0 and not exceed ₹1,000,000,000";
        }
        return service.deposit(id, amount) ? 
               "Deposit of ₹" + amount + " successful" : 
               "Deposit failed: Invalid user or amount";
    }

    // Withdraw amount with balance check
    @PostMapping("/{id}/withdraw")
    public String withdraw(@PathVariable Long id, @RequestParam double amount) {
        boolean result = service.withdraw(id, amount);
        if (!result) {
            double balance = service.checkBalance(id);
            return balance == -1.0
                ? "Withdrawal failed: User not found"
                : "Withdrawal failed: Insufficient balance or invalid amount";
        }
        return "Withdrawal of ₹" + amount + " successful";
    }
}
