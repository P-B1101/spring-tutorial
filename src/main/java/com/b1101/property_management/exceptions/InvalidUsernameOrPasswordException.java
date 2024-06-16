package com.b1101.property_management.exceptions;

import lombok.Getter;
import lombok.Setter;

public class InvalidUsernameOrPasswordException extends Exception {
    @Getter
    @Setter
    public static class InvalidUsernameOrPasswordExceptionMessage {
        private String message;
    }
}
