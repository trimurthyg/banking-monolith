package com.bank.banking_monolith.dto;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String name;
    private String email;
    private String phoneNumber;
}
