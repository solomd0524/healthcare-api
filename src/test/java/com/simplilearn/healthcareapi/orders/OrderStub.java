package com.simplilearn.healthcareapi.orders;

import java.math.BigDecimal;

public class OrderStub extends Order {

    public OrderStub() {
        super.setOrderId(1L);
        super.setUserId(1L);
        super.setMedicineId(1L);
        super.setMedicineName("Advil");
        super.setOrderQty(3L);
        super.setTotal(BigDecimal.valueOf(60.00));
        super.setStatus("Shipped");

    }
}
