package Ejercicio4;

import java.util.ArrayList;
import java.util.List;

// Definicion de la clase Hotel
public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;

    // Constructor de la clase Hotel
    public Hotel(String nombre, int numHabitaciones) {
        this.nombre = nombre;
        habitaciones = new ArrayList<>();
        
        // Crear habitaciones numeradas y agregarlas a la lista de habitaciones del hotel
        for (int i = 1; i <= numHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    // Metodo para obtener el nombre del hotel
    public String getNombre() {
        return nombre;
    }

    // Metodo para obtener la lista de habitaciones disponibles en el hotel
    public List<Habitacion> getHabitacionesDisponibles() {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getOcupante().isEmpty()) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    // Metodo para reservar una habitacion en el hotel para un cliente especifico
    public Habitacion reservarHabitacion(String cliente, int numero) {
        List<Habitacion> disponibles = getHabitacionesDisponibles();
        if (disponibles.isEmpty()) {
            return null; // No hay habitaciones disponibles para reservar
        }
        int indiceEncontrado = encontrarIndiceHabitacion(disponibles, numero);

        Habitacion habitacion = disponibles.get(indiceEncontrado);
        habitacion.reservar(cliente);
        return habitacion;
    }

    // Metodo para cancelar la reserva de una habitacion en el hotel
    public void cancelarReserva(int numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion) {
                habitacion.cancelarReserva();
                return;
            }
        }
    }

    // Metodo para encontrar el indice de una habitacion en una lista dada su numero
    public int encontrarIndiceHabitacion(List<Habitacion> lista, int numeroHabitacionBuscada) {
        for (int i = 0; i < lista.size(); i++) {
            Habitacion habitacion = lista.get(i);
            if (habitacion.getNumero() == numeroHabitacionBuscada) {
                return i; // Devolvemos el indice donde se encontro la habitacion
            }
        }
        return -1; // Devolvemos -1 si la habitacion no se encuentra en la lista
    }

    // Sobrescritura del metodo toString() para mostrar el nombre del hotel en representaciones de cadena
    @Override
    public String toString() {
        return nombre; // Mostrar el nombre del hotel en representaciones de cadena
    }
}
