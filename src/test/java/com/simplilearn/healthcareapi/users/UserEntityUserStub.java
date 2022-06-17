package com.simplilearn.healthcareapi.users;

import com.simplilearn.healthcareapi.roles.RoleEntity;

import java.time.ZonedDateTime;
import java.util.Set;

public class UserEntityUserStub extends UserEntity {

    public UserEntityUserStub() {
        super.setUserId(1L);
        super.setFirstName("Dave");
        super.setLastName("Solomon");
        super.setAddress("432 Towny Road Groton, CT 014032");
        super.setEmailAddress("dsol@gmail.com");
        super.setDateOfBirth(ZonedDateTime.parse("2012-06-20T12:30:40.000-05:00"));
        super.setUserName("dsol");
        super.setPassword("happy");
        super.setEnabled(true);

        RoleEntity role = new RoleEntity();
        role.setId(1);
        role.setRoleName("user");

        Set<RoleEntity> roles = Set.of(role);

        super.setRoles(roles);
    }
}
