package com.simplilearn.healthcareapi.orders;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ORDER_TBL")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "ORDER_NUMBER")
    private String orderNumber;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "MEDICINE_ID")
    private Long medicineId;

    @Column(name = "ORDER_QTY")
    private Long orderQty;

    @Column(name = "TOTAL")
    private BigDecimal total;

    @Column(name = "STATUS")
    private String status;
}
