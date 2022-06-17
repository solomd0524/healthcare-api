package com.simplilearn.healthcareapi.cart;

import java.math.BigDecimal;

public class CartProjectionStub implements CartProjection {

    @Override
    public Long getId() {
        return 1L;
    }

    @Override
    public Long getUserId() {
        return 1L;
    }

    @Override
    public String getFirstName() {
        return "David";
    }

    @Override
    public String getLastName() {
        return "Solomon";
    }

    @Override
    public String getAddress() {
        return "432 Towny Road Groton, CT 014032";
    }

    @Override
    public Long getMedicineId() {
        return 1L;
    }

    @Override
    public String getMedicineName() {
        return "Advil";
    }

    @Override
    public Long getQuantityOrdered() {
        return 3L;
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(20.00);
    }

    @Override
    public BigDecimal getDiscount() {
        return BigDecimal.valueOf(0.00);
    }

    @Override
    public BigDecimal getSubTotal() {
        return BigDecimal.valueOf(60.00);
    }
}
