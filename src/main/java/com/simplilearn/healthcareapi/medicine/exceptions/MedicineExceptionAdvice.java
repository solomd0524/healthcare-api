package com.simplilearn.healthcareapi.medicine.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MedicineExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(MedicineNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String medicineNotFoundHandler(MedicineNotFoundException ex) {
        return ex.getMessage();
    }
}
