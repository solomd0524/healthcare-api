package com.simplilearn.healthcareapi.accounts;

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
@Table(name = "ACCOUNT_TBL")
public class AccountEntity {

    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FUNDS_AVAILABLE")
    private BigDecimal fundsAvailable;
}
