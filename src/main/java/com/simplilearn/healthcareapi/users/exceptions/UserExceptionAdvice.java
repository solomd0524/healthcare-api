package com.simplilearn.healthcareapi.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class UserExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(UserLogInFailedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userLoginFailedHandler(UserLogInFailedException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserIsNotAdminException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userIsNotAdminException(UserIsNotAdminException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UserNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UserNameNotFoundHandler(UserNameNotFoundException ex) {
        return ex.getMessage();
    }
}
