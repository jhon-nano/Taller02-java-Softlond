import javax.swing.JOptionPane;

import Ejercicio1.Alumno;
import Ejercicio1.SistemaAlumnos;

public class Ejercicio1 {
    public static void main(String[] args) {
        SistemaAlumnos sistema = new SistemaAlumnos();

        // Crear algunos alumnos
        Alumno alumno1 = new Alumno("Jhon", 20);
        Alumno alumno2 = new Alumno("Juliana", 21);

        // Agregar los alumnos al sistema
        sistema.agregarAlumno(alumno1);
        sistema.agregarAlumno(alumno2);

        // Asignar calificaciones a los alumnos
        sistema.asignarCalificacion("Jhon", 8.5);
        sistema.asignarCalificacion("Jhon", 9.0);
        sistema.asignarCalificacion("Juliana", 7.8);

        while (true) {
            String[] opciones = {
                    "Agregar Alumno",
                    "Agregar Calificaciones",
                    "Ver Promedio Calificaciones",
                    "Salir"
            };

            // Crear la lista de alumnos con su edad para mostrar en el menu
            StringBuilder listaAlumnos = new StringBuilder("Alumnos: " + sistema.countAlumnos() + "\n");
            for (Alumno alumno : sistema.getAlumnos()) {
                listaAlumnos.append(alumno.getNombre()).append(" (").append(alumno.getEdad()).append(" años)")
                        .append("\n");
            }

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opcion:\n" + listaAlumnos.toString(),
                    "Sistema de Alumnos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (seleccion) {
                case 0: // Agregar Alumno
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del alumno:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del alumno:"));
                    Alumno alumno = new Alumno(nombre, edad);
                    if (sistema.agregarAlumno(alumno)) {
                        JOptionPane.showMessageDialog(null, "Alumno asignado con exito.", "exito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Alumno ya registrado.", "Error",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 1: // Agregar Calificaciones
                    String nombreAlumno = JOptionPane.showInputDialog(null, "Ingrese el nombre del alumno:");

                    Alumno alumnoEncontrado = sistema.buscarAlumno(nombreAlumno);
                    if (alumnoEncontrado != null) {
                        double calificacion = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la calificacion:"));
                        alumnoEncontrado.agregarCalificacion(calificacion);
                        JOptionPane.showMessageDialog(null, "Calificacion asignada con exito.", "exito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Alumno no encontrado.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 2: // Ver Promedio Calificaciones
                    String informacionAlumnos = sistema.obtenerInformacionAlumnos();
                    JOptionPane.showMessageDialog(null, informacionAlumnos, "Informacion de Alumnos",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3: // Salir
                    System.exit(0);
                    break;
            }
        }
    }
}
