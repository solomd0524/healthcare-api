package com.simplilearn.healthcareapi.cart;

import java.math.BigDecimal;

public class CartStub extends Cart {

    public CartStub() {
        super.setId(1L);
        super.setFirstName("Dave");
        super.setLastName("Solomon");
        super.setAddress("432 Towny Road Groton, CT 014032");
        super.setUserId(1L);
        super.setMedicineId(1L);
        super.setMedicineName("Advil");
        super.setPrice(BigDecimal.valueOf(20.00));
        super.setDiscount(BigDecimal.valueOf(0.00));
        super.setQuantityOrdered(3L);
        super.setSubTotal(BigDecimal.valueOf(60.00));
    }
}
