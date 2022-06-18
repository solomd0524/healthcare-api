package com.simplilearn.healthcareapi.medicine;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public interface MedicineProjection {

     Long getMedicineId();

     String getMedicineName();

     String getManufacturer();

     String getUses();

     BigDecimal getPrice();

     BigDecimal getDiscount();

     Long getQuantity();

     ZonedDateTime getExpirationDate();
}
