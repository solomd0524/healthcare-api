package com.simplilearn.healthcareapi.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @Column(name = "FUNDS_AVAILABLE")
    private BigDecimal fundsAvailable;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "IS_ADMIN")
    private String isAdmin;

    @Override
    public String toString() {
        return "UserEntity{" +
                " userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", accountId=" + accountId +
                ", userName=" + userName +
                ", password='" + password + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                '}';
    }
}
