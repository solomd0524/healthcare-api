package com.simplilearn.healthcareapi.cart;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private Long Id;

    private Long userId;

    private String firstName;

    private String lastName;

    private String address;

    private Long medicineId;

    private String medicineName;

    private BigDecimal price;

    private Long quantityOrdered;

    private BigDecimal discount;

    private BigDecimal subTotal;
}
