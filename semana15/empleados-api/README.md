# API de Empleados - Semana 15

Proyecto Spring Boot con Clean Architecture, DDD, Repository Pattern y SOLID.

## Requisitos
- Java 17
- Maven
- Spring Boot
- Base de datos H2

## Capas
- **Domain:** Employee, Salary e interfaz EmployeeRepository.
- **Application:** EmployeeService, EmployeeRequest y EmployeeResponse.
- **Infrastructure:** entidades JPA, Spring Data y adaptador del repositorio.
- **Presentation:** controlador REST y manejo de errores.

Las dependencias apuntan hacia el dominio. El dominio no importa Spring ni JPA; la implementación de persistencia se encuentra en infraestructura.

## Ejecutar
```bash
mvn clean test
mvn spring-boot:run
```

La API queda disponible en `http://localhost:8080/api/empleados`.
Consola H2: `http://localhost:8080/h2-console`
JDBC URL: `jdbc:h2:mem:empleadosdb`

## Endpoints
| Método | Ruta | Acción |
|---|---|---|
| POST | /api/empleados | Crear empleado |
| GET | /api/empleados | Listar empleados |
| GET | /api/empleados/{id} | Buscar por ID |
| PUT | /api/empleados/{id} | Actualizar empleado |
| DELETE | /api/empleados/{id} | Eliminar empleado |

## Ejemplo POST
```json
{
  "nombre": "Ana Perez",
  "email": "ana@mail.com",
  "salario": 5000,
  "departamento": "Sistemas"
}
```
