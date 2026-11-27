package com.example.empleados.application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class EmployeeRequest {
    @NotBlank
    private String nombre;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal salario;

    @NotBlank
    private String departamento;

    public EmployeeRequest() {}

    public EmployeeRequest(String nombre, String email,
                           BigDecimal salario, String departamento) {
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public BigDecimal getSalario() { return salario; }
    public String getDepartamento() { return departamento; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
}
