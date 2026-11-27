package com.example.empleados.infrastructure.persistence;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employees")
public class EmployeeJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private BigDecimal salario;

    @Column(nullable = false)
    private String departamento;

    public EmployeeJpaEntity() {}

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public BigDecimal getSalario() { return salario; }
    public String getDepartamento() { return departamento; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
}
