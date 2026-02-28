package com.bank.banking_monolith.dto;

import lombok.Data;

@Data
public class CreateAccountRequest {
    private Long userId;
    private String accountType;
}
