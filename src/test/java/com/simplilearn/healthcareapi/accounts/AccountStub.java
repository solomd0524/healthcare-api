package com.simplilearn.healthcareapi.accounts;

import java.math.BigDecimal;

public class AccountStub extends Account {

    public AccountStub() {

        super.setAccountId(1L);
        super.setAccountNumber("BOA-01");
        super.setAccountName("Bank of America");
        super.setUserId(1L);
        super.setFundsAvailable(BigDecimal.valueOf(1000.00));
    }
}
