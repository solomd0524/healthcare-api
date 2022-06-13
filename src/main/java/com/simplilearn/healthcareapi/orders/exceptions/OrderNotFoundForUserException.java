package com.simplilearn.healthcareapi.orders.exceptions;

public class OrderNotFoundForUserException extends RuntimeException {

    public OrderNotFoundForUserException(Long id) {

        super("Orders do not exist for user id = " + id);
    }
}
