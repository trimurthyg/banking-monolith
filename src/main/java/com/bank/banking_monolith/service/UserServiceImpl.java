package com.bank.banking_monolith.service;

import com.bank.banking_monolith.dto.CreateUserRequest;
import com.bank.banking_monolith.entity.User;
import com.bank.banking_monolith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();

        return userRepository.save(user);
    }
}
