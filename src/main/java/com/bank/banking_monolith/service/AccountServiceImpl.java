package com.bank.banking_monolith.service;

import com.bank.banking_monolith.dto.CreateAccountRequest;
import com.bank.banking_monolith.entity.Account;
import com.bank.banking_monolith.entity.User;
import com.bank.banking_monolith.repository.AccountRepository;
import com.bank.banking_monolith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;


    @Override
    public Account createAccount(CreateAccountRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = Account.builder()
                .accountNumber(generateAccountNumber())
                .accountType(request.getAccountType())
                .balance(BigDecimal.ZERO)
                .user(user)
                .build();

        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(Long accountId) {

        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    private String generateAccountNumber() {

        // Simple account number generation logic (for demonstration purposes)
        return "ACC" + System.currentTimeMillis()
                + new Random().nextInt(999);
    }
}
