package com.simplilearn.healthcareapi.medicine;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "MEDICINE_TBL")
public class MedicineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEDICINE_ID")
    private Long medicineId;

    @Column(name = "MEDICINE_NAME")
    private String medicineName;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "USES")
    private String uses;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "EXPIRATION_DATE")
    private ZonedDateTime expirationDate;
}
