package com.bank.banking_monolith.service;

import com.bank.banking_monolith.dto.CreateAccountRequest;
import com.bank.banking_monolith.entity.Account;

import java.math.BigDecimal;

public interface AccountService {

    Account createAccount(CreateAccountRequest request);

    Account getAccount(Long accountId);

    void deposit(Long accountId, BigDecimal amount);

    void withdraw(Long accountId, BigDecimal amount);
}
