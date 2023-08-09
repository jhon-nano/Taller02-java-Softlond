package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

// Definicion de la clase SistemaAlumnos
public class SistemaAlumnos {
    private List<Alumno> alumnos;

    // Constructor de la clase SistemaAlumnos
    public SistemaAlumnos() {
        alumnos = new ArrayList<>();
    }

    // Agrega un alumno al sistema
    public Boolean agregarAlumno(Alumno alum) {
        // Verifica si ya existe un alumno con el mismo nombre
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(alum.getNombre())) {
                return false; // Retorna falso si el alumno ya existe en el sistema
            }
        }
        alumnos.add(alum); // Agrega el alumno a la lista si no se encuentra
        return true; // Retorna verdadero si el alumno se agrega correctamente
    }

    // Asigna una calificacion a un alumno por su nombre
    public void asignarCalificacion(String nombreAlumno, double calificacion) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(nombreAlumno)) {
                alumno.agregarCalificacion(calificacion); // Agrega la calificacion al alumno encontrado
                break;
            }
        }
    }

    // Obtiene la informacion de todos los alumnos en el sistema
    public String obtenerInformacionAlumnos() {
        StringBuilder informacion = new StringBuilder();
        for (Alumno alumno : alumnos) {
            informacion.append(alumno.toString()).append("\n-----------------------------\n");
        }
        return informacion.toString(); // Retorna la informacion de todos los alumnos en formato de cadena
    }

    // Obtiene la lista de alumnos en el sistema
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    // Busca un alumno por su nombre y lo retorna
    public Alumno buscarAlumno(String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                return alumno; // Retorna el alumno si se encuentra en el sistema
            }
        }
        return null; // Retorna nulo si no se encuentra el alumno
    }

    // Retorna la cantidad de alumnos en el sistema
    public int countAlumnos() {
        return alumnos.size();
    }
}
