package com.simplilearn.healthcareapi.accounts;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

    AccountRepository accountRepository;
    AccountService accountService;

    @GetMapping(value = "/api/admin/accounts")
    public Iterable<AccountEntity> findAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping(value = "/api/user/{id}/accounts")
    public Account getAccountByUserId(@PathVariable("id") Long userId) {
        return accountService.getAccountByUserId(userId);
    }

    @PostMapping(value = "/api/user/accounts")
    public AccountEntity addAccount(@RequestBody AccountEntity account) {
        return accountRepository.save(account);
    }

    @PutMapping(value = "/api/user/accounts")
    public AccountEntity updateAccount(@RequestBody AccountEntity account) {
        return accountRepository.save(account);
    }

    @DeleteMapping(value = "/api/admin/accounts")
    public void deleteAccount(@RequestBody AccountEntity account) {
        accountRepository.delete(account);
    }
}
