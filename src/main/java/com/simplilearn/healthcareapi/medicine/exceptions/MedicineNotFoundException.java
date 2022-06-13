package com.simplilearn.healthcareapi.medicine.exceptions;

public class MedicineNotFoundException extends RuntimeException {

    public MedicineNotFoundException(Long id) {

        super("Medicine does not exists where medicine id = " + id);
    }
}
