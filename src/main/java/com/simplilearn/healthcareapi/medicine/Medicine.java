package com.simplilearn.healthcareapi.medicine;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {

    private Long medicineId;

    private String medicineName;

    private String manufacturer;

    private String uses;

    private BigDecimal price;

    private BigDecimal discount;

    private Long quantity;

    private ZonedDateTime expirationDate;
}
