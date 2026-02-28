package com.bank.banking_monolith.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {

    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
}
