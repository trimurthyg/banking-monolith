package com.bank.banking_monolith.service;

import com.bank.banking_monolith.dto.CreateAccountRequest;
import com.bank.banking_monolith.entity.Account;

public interface AccountService {

    Account createAccount(CreateAccountRequest request);

    Account getAccount(Long accountId);
}
