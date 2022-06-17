package com.simplilearn.healthcareapi.users;

import java.time.ZonedDateTime;

public class UserStub extends User {


    public UserStub() {
        super.setUserId(1L);
        super.setFirstName("Dave");
        super.setLastName("Solomon");
        super.setAddress("432 Towny Road Groton, CT 014032");
        super.setEmailAddress("dsol@gmail.com");
        super.setDateOfBirth(ZonedDateTime.parse("2012-06-20T12:30:40.000-05:00"));
        super.setUserName("dsol");
        super.setPassword("happy");
    }
}
