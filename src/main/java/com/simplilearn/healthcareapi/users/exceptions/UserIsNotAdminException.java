package com.simplilearn.healthcareapi.users.exceptions;

public class UserIsNotAdminException extends RuntimeException {

    public UserIsNotAdminException(String userName) {
        super(userName + "  Does not have admin rights. Please check your credentials and try again.");
    }
}
