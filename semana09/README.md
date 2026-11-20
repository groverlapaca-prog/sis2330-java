# Gestor de Tareas - Navegación Multi-Vista

## Descripción
Aplicación web desarrollada con Java y Vaadin.
Permite registrar tareas, visualizar un listado
y consultar el detalle de cada tarea.

## Cómo ejecutar

mvn spring-boot:run

Abrir http://localhost:8080

## Rutas

- / : Lista de tareas
- /tareas/{id} : Detalle de una tarea
- /acerca : Información del proyecto

## Estructura

- Tarea.java: Modelo de datos
- MainLayout.java: Menú lateral
- TareasView.java: Listado de tareas
- TareaDetalleView.java: Detalle por ID
- AcercaDeView.java: Información del proyecto
-
