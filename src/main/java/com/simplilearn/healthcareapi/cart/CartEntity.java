package com.simplilearn.healthcareapi.cart;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "CART_TBL")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    private Long id;

    @Column(name = "MEDICINE_ID")
    private Long medicineId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "QUANTITY_ORDERED")
    private Long quantityOrdered;
}
