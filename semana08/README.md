# Gestor de Tareas - Grid y CRUD

## Descripción

Aplicación web desarrollada con Java, Spring Boot y Vaadin.

Permite gestionar tareas mediante una tabla Grid y un formulario
validado con Binder.

## Funcionalidades

- Agregar tareas.
- Mostrar tareas.
- Editar tareas.
- Eliminar tareas.
- Marcar tareas como completadas.
- Validar descripción obligatoria.

## Tecnologías

- Java 17
- Maven
- Spring Boot
- Vaadin

## Cómo ejecutar

mvn spring-boot:run

Abrir en el navegador:

http://localhost:8080

## Estructura

- Tarea.java: record de tareas.
- TareaEditable.java: clase mutable para Binder.
- TareasView.java: interfaz principal.

## Nota

Los datos se almacenan en memoria y se pierden
al reiniciar la aplicación.
