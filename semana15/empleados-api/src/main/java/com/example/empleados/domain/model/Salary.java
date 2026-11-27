package com.example.empleados.domain.model;

import java.math.BigDecimal;

public final class Salary {
    private final BigDecimal amount;

    public Salary(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El salario no puede ser negativo ni nulo");
        }
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
