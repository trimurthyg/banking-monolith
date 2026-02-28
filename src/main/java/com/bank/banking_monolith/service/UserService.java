package com.bank.banking_monolith.service;

import com.bank.banking_monolith.dto.CreateUserRequest;
import com.bank.banking_monolith.entity.User;

public interface UserService {
    User createUser(CreateUserRequest request);
}
