package com.simplilearn.healthcareapi.accounts;

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
public class Account {

    private Long accountId;

    private String accountNumber;

    private String accountName;

    private Long userId;

    private BigDecimal fundsAvailable;

}
