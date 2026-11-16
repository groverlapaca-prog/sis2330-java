# SIS2330 - SEMANA 05
## Sistema de Estudiantes Avanzado

### Descripcion
Sistema desarrollado en Java para administrar estudiantes,
registrar sus datos, buscar por codigo, actualizar promedios,
mostrar rankings y eliminar registros.

### Colecciones utilizadas

1. HashMap:
Se utiliza para buscar estudiantes por codigo de manera eficiente.

2. TreeSet:
Se utiliza para mantener los estudiantes ordenados por promedio
de mayor a menor. Si existe empate, se ordena por codigo.

3. ArrayList:
Se utiliza para devolver el ranking y el Top N sin exponer
la estructura interna del TreeSet.

### Funcionalidades
- Registrar estudiantes.
- Buscar por codigo.
- Actualizar promedio.
- Mostrar ranking.
- Obtener Top N.
- Eliminar estudiantes.

### Compilacion y ejecucion
Desde la carpeta semana05:

javac -d out src/modelo/Estudiante.java src/servicio/SistemaEstudiantes.java src/Principal.java

java -cp out Principal
