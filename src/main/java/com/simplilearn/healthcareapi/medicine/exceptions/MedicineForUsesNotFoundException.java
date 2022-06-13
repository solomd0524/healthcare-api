package com.simplilearn.healthcareapi.medicine.exceptions;

public class MedicineForUsesNotFoundException extends RuntimeException {

    public MedicineForUsesNotFoundException(String uses) {

        super("Medicine does not exists for uses : " + uses);
    }
}
