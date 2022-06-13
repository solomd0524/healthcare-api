package com.simplilearn.healthcareapi.orders.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class OrderExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(OrderNotFoundForUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String orderNotFoundForUserHandler(OrderNotFoundForUserException ex) {
        return ex.getMessage();
    }
}
