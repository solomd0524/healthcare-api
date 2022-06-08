package com.simplilearn.healthcareapi.users.exceptions;

public class UserLogInFailedException extends RuntimeException {

    public UserLogInFailedException(String userName, String password) {
        super("Log in failed for userName = " + userName + ", password = " + password + "." + " Please check your credentials and try again.");
    }
}
