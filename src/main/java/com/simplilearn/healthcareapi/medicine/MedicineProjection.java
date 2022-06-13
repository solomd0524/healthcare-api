package com.simplilearn.healthcareapi.medicine;

import java.math.BigDecimal;
import java.util.Date;

public interface MedicineProjection {

     Long getMedicineId();

     String getMedicineName();

     String getManufacturer();

     String getUses();

     BigDecimal getPrice();

     BigDecimal getDiscount();

     Long getQuantity();

     Date getExpirationDate();
}
