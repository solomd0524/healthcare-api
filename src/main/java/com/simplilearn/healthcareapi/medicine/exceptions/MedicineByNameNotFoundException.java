package com.simplilearn.healthcareapi.medicine.exceptions;

public class MedicineByNameNotFoundException extends RuntimeException {

    public MedicineByNameNotFoundException(String name) {

        super("Medicine does not exists where name is : " + name);
    }
}
