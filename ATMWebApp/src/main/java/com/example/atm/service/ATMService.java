package com.example.atm.service;

import com.example.atm.model.UserAccount;
import com.example.atm.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ATMService {

    @Autowired
    private UserAccountRepository repository;

    public UserAccount login(int pin) {
        return repository.findByPin(pin).orElse(null);
    }

    public double checkBalance(Long id) {
        Optional<UserAccount> user = repository.findById(id);
        return user.map(UserAccount::getBalance).orElse(-1.0);
    }

    public boolean deposit(Long id, double amount) {
        Optional<UserAccount> userOpt = repository.findById(id);
        if (userOpt.isPresent() && amount > 0) {
            UserAccount user = userOpt.get();
            user.setBalance(user.getBalance() + amount);
            repository.save(user);
            return true;
        }
        return false;
    }

    public boolean withdraw(Long id, double amount) {
        Optional<UserAccount> userOpt = repository.findById(id);
        if (userOpt.isPresent()) {
            UserAccount user = userOpt.get();
            if (amount > 0 && user.getBalance() >= amount) {
                user.setBalance(user.getBalance() - amount);
                repository.save(user);
                return true;
            }
        }
        return false;
    }
}
