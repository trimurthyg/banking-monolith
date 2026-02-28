package com.bank.banking_monolith.controller;

import com.bank.banking_monolith.dto.CreateAccountRequest;
import com.bank.banking_monolith.entity.Account;
import com.bank.banking_monolith.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody CreateAccountRequest request) {

        return accountService.createAccount(request);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
}
