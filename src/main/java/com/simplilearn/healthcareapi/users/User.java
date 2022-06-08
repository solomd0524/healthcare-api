package com.simplilearn.healthcareapi.users;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;

    private String firstName;

    private String lastName;

    private String address;

    private String emailAddress;

    private Date dateOfBirth;

    private Long accountId;

    private BigDecimal fundsAvailable;

    private String userName;

    private String password;

    private String isAdmin;
}
