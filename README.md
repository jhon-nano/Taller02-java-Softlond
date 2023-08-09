# Taller 2 - Ejercicios Resueltos en Java

### Taller de Seminario. Softlond 2023

1. **Crea una clase Alumno con propiedades como nombre, edad y calificaciones. Luego, crea una clase SistemaAlumnos que permite agregar alumnos,asignar calificaciones , calcular el promedio de sus calificaciones y mostrar la información de cada alumno.** (`src\Ejercicio1.java`)
2. **Crea una clase ConversorMonedas que contenga métodos para convertir una cantidad de dinero de una moneda a otra, por ejemplo, de dólares a euros o de pesos a dólares.** (`src\Ejercicio2.java`)
3. **Crea una clase Calculadora que contenga métodos para realizar operaciones matemáticas básicas, como suma, resta, multiplicación y división.** (`src\Ejercicio3.java`)
4. **Crear un sistema de reservas de hotel que permita a los clientes corporativos reservar múltiples habitaciones en diferentes hoteles para hospedar a su personal. Debes tener clases como Hotel, Habitación, Cliente, y Reserva. Implementa métodos para listar habitaciones disponibles, realizar reservas y cancelar reservas.**(`src\Ejercicio4.java`)
  - Al final de la ejecución del programa debe mostrar la siguiente info:
     - Nombre de la empresa que reservó
    - Nombre y cédula de quien ocupará cada habitación y número de la habitación que ocupará. Esto para cada hotel

# Proyectos de Ejercicios Java

Este es un proyecto que contiene cuatro ejercicios de programacion en Java: Sistema de Alumnos, Conversor de Monedas, Calculadora y Sistema de Reservas de Hoteles. Cada ejercicio tiene su propia funcionalidad y se abordan diferentes aspectos de la programacion orientada a objetos.

## Contenido

- [Sistema de Alumnos](#sistema-de-gestion-de-alumnos)
- [Conversor de Monedas](#sistema-de-conversor-de-monedas)
- [Calculadora](#calculadora-simple)
- [Sistema de Reservas de Hoteles](#sistema-de-reservas-hoteleras)

---

# Sistema de Gestion de Alumnos

Este es un sistema de gestion de alumnos en Java que permite administrar informacion de alumnos y sus calificaciones.

## Contenido del Sistema de Gestion de Alumnos

- [Introduccion](#introduccion-del-sistema-de-gestion-de-alumnos)
- [Como Usar](#como-usar-del-sistema-de-gestion-de-alumnos)
  - [Agregar Alumno](#agregar-alumno)
  - [Agregar Calificaciones](#agregar-calificaciones)
  - [Ver Promedio de Calificaciones](#ver-promedio-de-calificaciones)
- [Ejecutar el Programa](#ejecutar-el-programa)

## Introduccion del Sistema de Gestion de Alumnos

El Sistema de Gestion de Alumnos es una aplicacion Java que permite a los usuarios almacenar y administrar informacion de estudiantes, incluyendo su nombre, edad y calificaciones.

## Como Usar del Sistema de Gestion de Alumnos

### Agregar Alumno

1. Ejecuta el programa.
2. Selecciona la opcion "Agregar Alumno".
3. Ingresa el nombre y la edad del nuevo alumno.
4. El sistema mostrara un mensaje de exito o error si el alumno ya esta registrado.

### Agregar Calificaciones

1. Ejecuta el programa.
2. Selecciona la opcion "Agregar Calificaciones".
3. Ingresa el nombre del alumno al que deseas asignar una calificacion.
4. Ingresa la calificacion.
5. El sistema mostrara un mensaje de exito o error si el alumno no se encuentra.

### Ver Promedio de Calificaciones

1. Ejecuta el programa.
2. Selecciona la opcion "Ver Promedio Calificaciones".
3. El sistema mostrara la informacion detallada de todos los alumnos y sus promedios de calificaciones.

## Ejecutar el Ejercicio1 del Sistema de Gestion de Alumnos

1. Compila y ejecuta el archivo `Ejercicio1.java`.
2. Sigue las instrucciones del menu para interactuar con el sistema de gestion de alumnos.

---

# Sistema de Conversor de Monedas

Este es un programa en Java que permite convertir cantidades de dinero entre diferentes monedas, como dolares, euros y pesos.

## Contenido de Conversor de Monedas

- [Introduccion](#introduccion-de-conversor-de-monedas)
- [Como Usar](#como-usar-de-conversor-de-monedas)
- [Ejecutar el Programa](#ejecutar-el-ejercicio2-de-conversor-de-moneda)

## Introduccion de Conversor de Monedas

El Conversor de Monedas es una herramienta que te permite convertir cantidades de dinero entre tres tipos de monedas: dolares, euros y pesos. Puedes especificar la moneda de origen, la moneda de destino y la cantidad que deseas convertir, y el programa calculara el equivalente en la moneda de destino utilizando los tipos de cambio proporcionados.

## Como Usar de Conversor de Monedas

Ejecuta el programa Ejercicio2.java.

Selecciona la moneda de origen y la moneda de destino utilizando los cuadros de dialogo.

Ingresa la cantidad que deseas convertir.

El programa mostrara el resultado de la conversion en un cuadro de dialogo informativo.

---

## Ejecutar el Ejercicio2 de Conversor de Moneda

1. Compila y ejecuta el archivo `Ejercicio2.java`.
2. Sigue las instrucciones del menu para interactuar con el sistema de gestion de alumnos.

---
# Calculadora Simple

Este es un programa de calculadora simple en Java que permite al usuario realizar operaciones basicas como suma, resta, multiplicacion y division.

## Contenido de Calculadora Simple

- [Introduccion](#introduccion)
- [Como Usar](#como-usar)
- [Ejecutar el Programa](#ejecutar-el-programa)

## Introduccion

Este programa implementa una calculadora simple que permite al usuario ingresar dos numeros y seleccionar una operacion (suma, resta, multiplicacion o division) para obtener el resultado.

## Como Usar de Calculadora Simple

1. Ejecute el programa.
2. Ingrese el primer numero cuando se le solicite.
3. Seleccione una operacion (suma, resta, multiplicacion o division).
4. Ingrese el segundo numero cuando se le solicite.
5. Se mostrara el resultado de la operacion en una ventana de dialogo.

---
# Sistema de Reservas Hoteleras

Este es un sistema de reservas hoteleras en Java que permite a los clientes realizar y administrar reservas en diferentes hoteles.

## Contenido de Sistema de Reservas Hoteleras

- [Introduccion](#introduccion)
- [Como Usar](#como-usar-de-sistema-de-reservas-hoteleras)
  - [Realizar Reserva](#realizar-reserva)
  - [Cancelar Reserva](#cancelar-reserva)
  - [Mostrar Informes](#mostrar-reservas)
    - [Clientes](#mostrar-reservas)
    - [Hoteles](#mostrar-reservas)
    - [Empresas](#mostrar-reservas)
  - [Nuevo](#mostrar-reservas)
    - [Cliente](#mostrar-reservas)
    - [Hotel](#mostrar-reservas)
- [Ejecutar el Programa](#ejecutar-el-ejercicio4-de-sistema-de-reservas-hoteleras)

## Introduccion de Sistema de Reservas Hoteleras

Este proyecto implementa un sistema de reservas hoteleras que permite a los clientes realizar y administrar sus reservas en diferentes hoteles. El sistema esta construido en Java y utiliza conceptos de programacion orientada a objetos para representar clientes, habitaciones, hoteles y reservas.

## Como Usar de Sistema de Reservas Hoteleras

A continuacion se describen los pasos para utilizar las principales funcionalidades del sistema.

### Realizar Reserva

1. Selecciona un cliente de la lista.
2. Selecciona un hotel de la lista.
3. Selecciona una habitacion disponible en el hotel.
4. La reserva se realiza exitosamente y se muestra un mensaje de confirmacion.

### Cancelar Reserva

1. Selecciona un cliente de la lista.
2. Selecciona la reserva que deseas cancelar.
3. La reserva se cancela exitosamente y se muestra un mensaje de confirmacion.

### Mostrar Reservas

1. Selecciona la opcion "Mostrar Informes".
2. Selecciona el Informe que deseas ver.
3. Se muestra una ventana con la informacion detallada.

### Nuevos Registros

1. Selecciona la opcion "Nuevo".
2. Selecciona la opcion "Hotel o Cliente".
 - Si selecciono Hotel.
1. Ingrese el nombre del Hotel.
2. Ingrese la cantidad habitaciones.
 - Si selecciono Cliente.
1. Ingrese el nombre del Cliente.
2. Ingrese el documento del Cliente.

## Ejecutar el Ejercicio4 de Sistema de Reservas Hoteleras

1. Compila y ejecuta el archivo `Ejercicio4.java`.
2. Sigue las instrucciones en la interfaz grafica para interactuar con el sistema.

---
# Instrucciones de uso

1. Clona este repositorio o descarga los archivos del taller.
2. Cada ejercicio está implementado en un archivo Java independiente y tiene un nombre descriptivo. Encuentra el ejercicio que deseas revisar en la lista anterior.
3. Compila y ejecuta el archivo Java correspondiente utilizando tu entorno de desarrollo preferido o desde la línea de comandos.

## Estructura del Folder

El espacio de trabajo contiene dos carpetas por defecto, donde:

- `src`: la carpeta para mantener las fuentes de cada ejercicio.
- `lib`: la carpeta para mantener las dependencias

Mientras tanto, los archivos de salida compilados se generarán en la carpeta `bin` de forma predeterminada.

**Autor**: Jhon Nestor Sanchez Vallejo