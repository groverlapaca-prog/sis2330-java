# Semana 04 - POO II

## Proyecto: Gestion de Vehiculos

### Objetivo
Desarrollar un sistema de gestion de vehiculos
utilizando los conceptos de Programacion Orientada
a Objetos en Java.

### Conceptos utilizados

1. Herencia mediante extends.
2. Polimorfismo.
3. Clases abstractas.
4. Interfaces.
5. Sobreescritura mediante @Override.
6. Upcasting.
7. instanceof.

### Clases creadas

- Vehiculo
- Auto
- Moto
- Camion
- Electrico
- AutoElectrico
- GestionVehiculos

### Funcionamiento

El programa registra cuatro vehiculos y los almacena
en una lista ArrayList<Vehiculo>.

Después recorre la lista utilizando polimorfismo.
Cuando encuentra un vehiculo electrico, ejecuta
el metodo cargarBateria().

### Resultado

El programa muestra la descripcion de cada vehiculo
y permite identificar los vehiculos electricos.
