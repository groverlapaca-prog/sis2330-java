# Gestor de Tareas (Vaadin)

## Descripcion

Aplicacion web Vaadin que permite agregar tareas
a una lista en memoria y verlas como texto plano.

## Como ejecutar

mvn spring-boot:run

Abrir en el navegador:

http://localhost:8080

## Estructura

- com.tareas.Tarea: record con id, descripcion y completada.
- com.tareas.views.TareasView: vista principal.

## Nota

Las tareas se pierden al reiniciar la aplicacion,
porque se almacenan en memoria.
