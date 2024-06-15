package com.b1101.property_management.exceptions;

import lombok.Getter;
import lombok.Setter;

public class UserAlreadyExistException extends Exception {
    @Override
    public String toString() {
        return "User already exists";
    }

    @Getter
    @Setter
    public static class UserAlreadyExistExceptionMessage {
        private String message;
    }
}
