package com.simplilearn.healthcareapi.cart;

import java.math.BigDecimal;

public interface CartProjection {

     Long getId();

     Long getUserId();

     String getFirstName();

     String getLastName();

     String getAddress();

     Long getMedicineId();

     String getMedicineName();

     BigDecimal getPrice();

     Long getQuantityOrdered();

    BigDecimal getDiscount();

     BigDecimal getSubTotal();
}
