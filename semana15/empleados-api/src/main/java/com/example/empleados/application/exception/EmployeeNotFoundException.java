package com.example.empleados.application.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("No existe un empleado con id: " + id);
    }
}
