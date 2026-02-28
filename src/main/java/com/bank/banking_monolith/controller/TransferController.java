package com.bank.banking_monolith.controller;

import com.bank.banking_monolith.dto.TransferRequest;
import com.bank.banking_monolith.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    public void transfer(@RequestBody TransferRequest request) {
        transferService.transferMoney(request);
    }

}
