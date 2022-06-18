package com.simplilearn.healthcareapi.accounts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    AccountRepository accountRepository;
    AccountMapper accountMapper;

    public Account getAccountByUserId(Long userId) {
        return accountMapper.map(accountRepository.getAccountByUserId(userId).orElse(null));
    }
}
