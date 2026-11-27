package com.example.empleados.application.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("Ya existe un empleado con el email: " + email);
    }
}
