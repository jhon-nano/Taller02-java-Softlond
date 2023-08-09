package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

// Definicion de la clase Alumno
public class Alumno {

    // Atributos de la clase Alumno
    private String nombre;
    private int edad;
    private List<Double> calificaciones;

    // Constructor de la clase Alumno
    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = new ArrayList<>(); // Inicializa la lista de calificaciones vacia
    }

    // Metodos de acceso para los atributos

    // Obtiene el nombre del alumno
    public String getNombre() {
        return nombre;
    }

    // Obtiene la edad del alumno
    public int getEdad() {
        return edad;
    }

    // Obtiene la lista de calificaciones del alumno
    public List<Double> getCalificaciones() {
        return calificaciones;
    }

    // Agrega una calificacion a la lista de calificaciones
    public void agregarCalificacion(double calificacion) {
        calificaciones.add(calificacion);
    }

    // Calcula el promedio de las calificaciones del alumno
    public double calcularPromedioCalificaciones() {
        if (calificaciones.isEmpty()) {
            return 0.0; // Si no hay calificaciones, el promedio es 0.0
        }

        double suma = 0.0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }

        return suma / calificaciones.size(); // Calcula el promedio dividiendo la suma entre la cantidad de calificaciones
    }

    // Representacion en formato de cadena de texto de un objeto Alumno
    @Override
    public String toString() {
        String result = "Nombre: " + nombre + "\n";
        result += "Edad: " + edad + "\n";
        result += "Calificaciones: " + calificaciones + "\n";
        result += "Promedio de Calificaciones: " + calcularPromedioCalificaciones() + "\n";
        return result; // Retorna la representacion en cadena de texto del objeto Alumno
    }

}
