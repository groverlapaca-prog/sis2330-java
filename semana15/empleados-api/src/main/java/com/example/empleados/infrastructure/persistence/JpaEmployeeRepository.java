package com.example.empleados.infrastructure.persistence;

import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;
import com.example.empleados.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaEmployeeRepository implements EmployeeRepository {
    private final SpringDataEmployeeRepository springRepo;

    public JpaEmployeeRepository(SpringDataEmployeeRepository springRepo) {
        this.springRepo = springRepo;
    }

    @Override
    public Employee findById(Long id) {
        return springRepo.findById(id).map(this::toDomain).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return springRepo.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeJpaEntity entity = toJpa(employee);
        return toDomain(springRepo.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        springRepo.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return springRepo.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return springRepo.existsByEmail(email);
    }

    private Employee toDomain(EmployeeJpaEntity entity) {
        return new Employee(
                entity.getId(),
                entity.getNombre(),
                entity.getEmail(),
                new Salary(entity.getSalario()),
                entity.getDepartamento()
        );
    }

    private EmployeeJpaEntity toJpa(Employee employee) {
        EmployeeJpaEntity entity = new EmployeeJpaEntity();
        entity.setId(employee.getId());
        entity.setNombre(employee.getNombre());
        entity.setEmail(employee.getEmail());
        entity.setSalario(employee.getSalary().getAmount());
        entity.setDepartamento(employee.getDepartamento());
        return entity;
    }
}
