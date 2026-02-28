package com.bank.banking_monolith.service;

import com.bank.banking_monolith.dto.TransferRequest;

public interface TransferService {

        void transferMoney(TransferRequest request);
}
