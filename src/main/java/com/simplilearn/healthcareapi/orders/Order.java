package com.simplilearn.healthcareapi.orders;


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
public class Order {

    private Long orderId;

    private String orderNumber;

    private Long userId;

    private Long medicineId;

    private String medicineName;

    private Long orderQty;

    private BigDecimal total;

    private String status;
}
