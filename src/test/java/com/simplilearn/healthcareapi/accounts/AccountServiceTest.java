package com.simplilearn.healthcareapi.accounts;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AccountService.class})
@Tag("UnitTest")
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private AccountMapper accountMapper;

    private static final Long USER_ID = 1L;
    private static final Account account = new AccountStub();
    private final AccountProjection accountProjection = new AccountProjectionStub();

    @Test
    void whenGetAccountByUserId_thenReturnAccount() {

        given(accountRepository.getAccountByUserId(anyLong())).willReturn(Optional.of(accountProjection));
        given(accountMapper.map(accountProjection)).willReturn(account);
        Account result = accountService.getAccountByUserId(USER_ID);

        assertThat(result).isNotNull();
        assertThat(result.getAccountId())
                .isEqualTo(accountProjection.getAccountId());

        verify(accountRepository, times(1)).getAccountByUserId(anyLong());
    }

    @Test
    void whenGetAccountByUserId_whereNoAccountIsFound_thenReturnHttpStatus200AndNullAccount() {
        given(accountRepository.getAccountByUserId(anyLong())).willReturn(Optional.empty());
        Account result = accountService.getAccountByUserId(USER_ID);
        assertThat(result).isNull();
    }
}