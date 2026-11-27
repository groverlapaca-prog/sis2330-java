package com.example.empleados.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEmployeeRepository
        extends JpaRepository<EmployeeJpaEntity, Long> {
    boolean existsByEmail(String email);
}
