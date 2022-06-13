package com.simplilearn.healthcareapi.orders;

import java.math.BigDecimal;

public interface OrderProjection {

    Long getOrderId();

    Long getUserId();

    Long getMedicineId();

    String getMedicineName();

    String getOrderNumber();

    Long getOrderQty();

    BigDecimal getTotal();

    String getStatus();
}
