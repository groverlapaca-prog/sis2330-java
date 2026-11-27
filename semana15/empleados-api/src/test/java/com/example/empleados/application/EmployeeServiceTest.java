package com.example.empleados.application;

import com.example.empleados.application.dto.EmployeeRequest;
import com.example.empleados.application.dto.EmployeeResponse;
import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;
import com.example.empleados.domain.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    void createEmployee() {
        EmployeeRequest request = new EmployeeRequest(
                "Ana", "ana@mail.com", new BigDecimal("5000"), "Sistemas");

        when(repository.existsByEmail("ana@mail.com")).thenReturn(false);
        when(repository.save(any(Employee.class))).thenAnswer(invocation -> {
            Employee e = invocation.getArgument(0);
            return new Employee(1L, e.getNombre(), e.getEmail(),
                    e.getSalary(), e.getDepartamento());
        });

        EmployeeResponse response = service.create(request);

        assertEquals(1L, response.getId());
        assertEquals("Ana", response.getNombre());
        verify(repository).save(any(Employee.class));
    }

    @Test
    void findAllEmployees() {
        Employee employee = new Employee(1L, "Ana", "ana@mail.com",
                new Salary(new BigDecimal("5000")), "Sistemas");
        when(repository.findAll()).thenReturn(List.of(employee));

        assertEquals(1, service.findAll().size());
    }
}
