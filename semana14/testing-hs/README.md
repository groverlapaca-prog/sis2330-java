# Proyecto Semana 14 - Haskell IV

## Descripcion

Proyecto desarrollado en Haskell para trabajar con pruebas
automaticas HUnit, QuickCheck y el patron State.

## Estructura

- Notas.hs: funciones para procesar notas de estudiantes.
- Historial.hs: registra consultas utilizando State.
- Main.hs: ejecuta el programa principal.
- Spec.hs: contiene las pruebas automaticas.

## Como ejecutar

Para compilar:

    stack build

Para ejecutar las pruebas:

    stack test

Para ejecutar el programa:

    stack run

## Aprendizaje

En este proyecto aprendi a utilizar HUnit para probar
funciones, QuickCheck para comprobar propiedades y State
para manejar un historial sin utilizar variables mutables.
