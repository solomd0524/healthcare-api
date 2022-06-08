package com.simplilearn.healthcareapi.users;

import java.math.BigDecimal;
import java.util.Date;

public interface UserProjection {

    Long getUserId();

    String getFirstName();

    String getLastName();

    String getAddress();

    String getEmailAddress();

    Date getDateOfBirth();

    Long getAccountId();

    BigDecimal getFundsAvailable();

    String getUserName();

    String getPassword();

    String getIsAdmin();
}
