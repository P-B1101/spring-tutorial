package com.b1101.property_management.service;

import java.util.List;

import com.b1101.property_management.exceptions.InvalidUsernameOrPasswordException;
import com.b1101.property_management.exceptions.UserAlreadyExistException;
import com.b1101.property_management.model.UserDto;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto register(UserDto userDto) throws UserAlreadyExistException;

    UserDto login(String username, String password) throws InvalidUsernameOrPasswordException;
}
