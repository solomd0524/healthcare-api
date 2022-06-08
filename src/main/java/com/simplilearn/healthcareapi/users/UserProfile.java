package com.simplilearn.healthcareapi.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    private Long userId;

    private String firstName;

    private String lastName;

    private String address;

    private String emailAddress;

    private String userName;

    private String password;

}
