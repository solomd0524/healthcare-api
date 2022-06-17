package com.simplilearn.healthcareapi.users;

import java.time.ZonedDateTime;

public class UserProjectionStub implements UserProjection {

    @Override
    public Long getUserId() {
        return 1L;
    }

    @Override
    public String getFirstName() {
        return "David";
    }

    @Override
    public String getLastName() {
        return "Solomon";
    }

    @Override
    public String getAddress() {
        return "432 Towny Road Groton, CT 014032";
    }

    @Override
    public String getEmailAddress() {
        return "dsol@gmail.com";
    }

    @Override
    public ZonedDateTime getDateOfBirth() {
        return ZonedDateTime.parse("1984-06-30T12:30:40.000-05:00");
    }

    @Override
    public String getUserName() {
        return "dsol";
    }

    @Override
    public String getPassword() {
        return "hello1";
    }

    public boolean getEnabled() {
        return true;
    }
}


