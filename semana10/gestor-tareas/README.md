# Gestor de Tareas

## Descripción

Aplicación web desarrollada con Spring Boot y Vaadin.

Permite administrar tareas mediante operaciones CRUD.

Los datos se guardan en el archivo tareas.json.

## Tecnologías

- Java 17
- Maven
- Spring Boot
- Vaadin
- Gson

## Cómo ejecutar

mvn spring-boot:run

Abrir en el navegador:

http://localhost:8080

## Empaquetar

mvn clean package

## Ejecutar JAR

java -jar target/gestor-tareas-0.0.1-SNAPSHOT.jar

## Persistencia

Las tareas se almacenan en tareas.json.

## Estructura

- Tarea: modelo de datos.
- TareaService: lógica y persistencia.
- TareasView: pantalla principal.
- TareaDetalleView: consulta por ID.
- TareaEditable: formulario.
- MainLayout: menú lateral.
