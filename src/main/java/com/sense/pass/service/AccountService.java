package com.sense.pass.service;

import com.sense.pass.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service // Serves to another Service or Controller
public class AccountService {

    // Don't use "@Autowired" use "private final" instead, for immutability and testability
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
