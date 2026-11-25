# Semana 13 - Persistencia de Estudiantes

## Descripción
Proyecto desarrollado en Haskell utilizando Stack.
Permite registrar estudiantes y guardar sus notas
en un archivo CSV.

## Archivo estudiantes.csv
Guarda los datos con el siguiente formato:

nombre,nota

Ejemplo:
Grover,85.0
Juan,70.0

## Manejo de errores
Se utiliza Either String Estudiante para detectar
líneas incorrectas sin detener el programa.

## Compilar
stack build

## Ejecutar
stack run

## Pruebas
stack test
