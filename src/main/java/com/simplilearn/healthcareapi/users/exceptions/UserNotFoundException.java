package com.simplilearn.healthcareapi.users.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User does not exists where user id = " + id);
    }
}
