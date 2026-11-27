package com.example.empleados.application;

import com.example.empleados.application.dto.EmployeeRequest;
import com.example.empleados.application.dto.EmployeeResponse;
import com.example.empleados.application.exception.EmailAlreadyExistsException;
import com.example.empleados.application.exception.EmployeeNotFoundException;
import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;
import com.example.empleados.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeResponse create(EmployeeRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        Employee employee = new Employee(
                null,
                request.getNombre(),
                request.getEmail(),
                new Salary(request.getSalario()),
                request.getDepartamento()
        );
        return toResponse(repository.save(employee));
    }

    public EmployeeResponse findById(Long id) {
        Employee employee = repository.findById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException(id);
        }
        return toResponse(employee);
    }

    public List<EmployeeResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public EmployeeResponse update(Long id, EmployeeRequest request) {
        Employee current = repository.findById(id);
        if (current == null) {
            throw new EmployeeNotFoundException(id);
        }

        if (!current.getEmail().equals(request.getEmail())
                && repository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        Employee updated = new Employee(
                id,
                request.getNombre(),
                request.getEmail(),
                new Salary(request.getSalario()),
                request.getDepartamento()
        );
        return toResponse(repository.save(updated));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        repository.deleteById(id);
    }

    private EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getNombre(),
                employee.getEmail(),
                employee.getSalary().getAmount(),
                employee.getDepartamento()
        );
    }
}
