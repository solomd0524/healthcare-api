package com.simplilearn.healthcareapi.accounts;

import java.math.BigDecimal;

public class AccountProjectionStub implements AccountProjection {

    @Override
    public Long getAccountId() {
        return 1L;
    }

    @Override
    public String getAccountNumber() {
        return "BOA-01";
    }

    @Override
    public String getAccountName() {
        return "Bank Of America";
    }

    @Override
    public Long getUserId() {
        return 1L;
    }

    @Override
    public BigDecimal getFundsAvailable() {
        return BigDecimal.valueOf(1000.00);
    }
}
