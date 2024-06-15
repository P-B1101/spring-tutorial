package com.b1101.property_management.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
}
