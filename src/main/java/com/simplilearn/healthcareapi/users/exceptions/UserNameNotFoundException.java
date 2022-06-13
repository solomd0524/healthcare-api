package com.simplilearn.healthcareapi.users.exceptions;

public class UserNameNotFoundException extends RuntimeException {

    public UserNameNotFoundException(String userName) {
        super("User does not exists where user name = " + userName);
    }
}
