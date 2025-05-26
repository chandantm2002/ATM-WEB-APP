// repository/UserAccountRepository.java
package com.example.atm.repository;

import com.example.atm.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByPin(int pin);
}
