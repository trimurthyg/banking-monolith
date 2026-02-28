package com.bank.banking_monolith.repository;

import com.bank.banking_monolith.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AccountRepository extends JpaRepository<Account, Long> {

}
