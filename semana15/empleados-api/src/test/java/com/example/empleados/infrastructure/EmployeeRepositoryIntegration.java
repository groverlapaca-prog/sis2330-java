package com.example.empleados.infrastructure;

import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;
import com.example.empleados.domain.repository.EmployeeRepository;
import com.example.empleados.EmpleadosApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = EmpleadosApiApplication.class)
class EmployeeRepositoryIntegrationTest {
    @Autowired
    private EmployeeRepository repository;

    @Test
    void savesAndFindsEmployeeInH2() {
        Employee employee = new Employee(null, "Carlos",
                "carlos.integration@mail.com",
                new Salary(new BigDecimal("4200")), "Ventas");

        Employee saved = repository.save(employee);

        assertNotNull(saved.getId());
        Employee found = repository.findById(saved.getId());
        assertNotNull(found);
        assertEquals("Carlos", found.getNombre());
    }
}
