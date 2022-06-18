package com.simplilearn.healthcareapi.accounts;

import java.math.BigDecimal;

public interface AccountProjection {

    Long getAccountId();

    String getAccountNumber();

    String getAccountName();

    Long getUserId();

    BigDecimal getFundsAvailable();
}
