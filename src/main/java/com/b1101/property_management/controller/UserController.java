package com.b1101.property_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.b1101.property_management.exceptions.UserAlreadyExistException;
import com.b1101.property_management.model.UserDto;
import com.b1101.property_management.service.UserService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        final List<UserDto> result = userService.getAllUsers();
        return new ResponseEntity<List<UserDto>>(result, HttpStatus.OK);
    }

    @PostMapping("/register")
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Object> register(@RequestBody UserDto user) {
        try {
            final UserDto response = userService.register(user);
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        } catch (UserAlreadyExistException e) {
            final UserAlreadyExistException.UserAlreadyExistExceptionMessage error = new UserAlreadyExistException.UserAlreadyExistExceptionMessage();
            error.setMessage("User with usernam " + user.getUsername() + " is already exists");
            return new ResponseEntity<Object>(error, HttpStatus.UNAUTHORIZED);
        }

    }

}
