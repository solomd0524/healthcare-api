package com.simplilearn.healthcareapi.medicine;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class MedicineStub extends Medicine {

    MedicineStub() {
        super.setMedicineId(1L);
        super.setMedicineName("Advil");
        super.setManufacturer("Novartis");
        super.setPrice(BigDecimal.valueOf(20.00));
        super.setQuantity(3L);
        super.setUses("Pain Management");
        super.setExpirationDate(ZonedDateTime.parse("2023-06-30T12:30:40.000-00:00"));
    }

}
