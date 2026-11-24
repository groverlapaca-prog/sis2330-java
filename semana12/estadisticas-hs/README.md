# Estadisticas de Estudiantes

Proyecto desarrollado en Haskell para calcular
estadisticas de un grupo de estudiantes.

## Modulos

- Estadisticas.hs
- Main.hs

## Funciones

- promedio: calcula el promedio del grupo.
- masAlto: encuentra la nota mas alta.
- ordenarPorNota: ordena por nota de mayor a menor.
- aprobados: muestra estudiantes con nota mayor o igual a 51.

## Como compilar

stack build

## Como ejecutar

stack run

## Ejemplo

Entrada:

3
Ana
90
Luis
45
Marta
70

Salida:

Promedio del grupo: 68.33333333333333
Mas alto: ("Ana",90.0)
Ordenados por nota: [("Ana",90.0),("Marta",70.0),("Luis",45.0)]
Aprobados: [("Ana",90.0),("Marta",70.0)]
