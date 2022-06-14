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

     String getPrice();

     Long getQuantityOrdered();

     Long getDiscount();

     BigDecimal getSubTotal();
}
