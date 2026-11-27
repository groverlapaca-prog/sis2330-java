package com.example.empleados.application.dto;

import java.math.BigDecimal;

public class EmployeeResponse {
    private final Long id;
    private final String nombre;
    private final String email;
    private final BigDecimal salario;
    private final String departamento;

    public EmployeeResponse(Long id, String nombre, String email,
                            BigDecimal salario, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public BigDecimal getSalario() { return salario; }
    public String getDepartamento() { return departamento; }
}
