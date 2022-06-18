package com.simplilearn.healthcareapi.medicine;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class MedicineProjectionStub implements MedicineProjection {
    @Override
    public Long getMedicineId() {
        return 1L;
    }

    @Override
    public String getMedicineName() {
        return "Advil";
    }

    @Override
    public String getManufacturer() {
        return "Novartis";
    }

    @Override
    public String getUses() {
        return "Pain Management";
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
    public Long getQuantity() {
        return 3L;
    }

    @Override
    public ZonedDateTime getExpirationDate() {
        return ZonedDateTime.parse("2023-06-20T12:30:40.000-05:00");
    }
}
