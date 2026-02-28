package com.bank.banking_monolith.service;

import com.bank.banking_monolith.dto.TransferRequest;
import com.bank.banking_monolith.entity.Account;
import com.bank.banking_monolith.entity.Transaction;
import com.bank.banking_monolith.repository.AccountRepository;
import com.bank.banking_monolith.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public void transferMoney(TransferRequest request) {

        // IDEMPOTENCY CHECK
        transactionRepository.findByReferenceId(request.getReferenceId())
                .ifPresent(txn -> {
                    throw new RuntimeException("Transaction already processed");
                });

        Account sender = accountRepository.findByIdForUpdate(request.getFromAccountId());

        Account receiver = accountRepository.findByIdForUpdate(request.getToAccountId());

        if (sender.getBalance().compareTo(request.getAmount()) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        // Debit
        sender.setBalance(sender.getBalance().subtract(request.getAmount()));

        // Credit
        receiver.setBalance(receiver.getBalance().add(request.getAmount()));

        accountRepository.save(sender);
        accountRepository.save(receiver);

        Transaction transaction = Transaction.builder()
                .referenceId(request.getReferenceId())
                .fromAccountId(sender.getId())
                .toAccountId(receiver.getId())
                .amount(request.getAmount())
                .status("SUCCESS")
                .createdAt(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);
    }
}
