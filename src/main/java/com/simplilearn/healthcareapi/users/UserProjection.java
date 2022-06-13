package com.simplilearn.healthcareapi.users;

import java.util.Date;

public interface UserProjection {

    Long getUserId();

    String getFirstName();

    String getLastName();

    String getAddress();

    String getEmailAddress();

    Date getDateOfBirth();

    String getUserName();

    String getPassword();

    String getActive();
}
