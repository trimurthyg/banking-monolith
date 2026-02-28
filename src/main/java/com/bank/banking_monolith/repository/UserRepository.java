package com.bank.banking_monolith.repository;

import com.bank.banking_monolith.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
