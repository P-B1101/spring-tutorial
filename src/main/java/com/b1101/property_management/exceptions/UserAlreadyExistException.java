package com.b1101.property_management.exceptions;

import lombok.Getter;
import lombok.Setter;

public class UserAlreadyExistException extends Exception {
    @Getter
    @Setter
    public static class UserAlreadyExistExceptionMessage {
        private String message;
    }
}
