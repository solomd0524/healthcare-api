package com.simplilearn.healthcareapi.users;

import java.time.ZonedDateTime;

public interface UserProjection {

    Long getUserId();

    String getFirstName();

    String getLastName();

    String getAddress();

    String getEmailAddress();

    ZonedDateTime getDateOfBirth();

    String getUserName();

    String getPassword();

    boolean getEnabled();
}
