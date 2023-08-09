package Ejercicio4;

import java.text.SimpleDateFormat;
import java.util.Date;

// Definición de la clase Reserva
public class Reserva {
    private Date fechaReserva;
    private Cliente cliente;
    private Hotel hotel;
    private Habitacion habitacion;

    // Constructor de la clase Reserva
    public Reserva(Cliente cliente, Hotel hotel, Habitacion habitacion) {
        this.fechaReserva = new Date(); // Fecha actual al crear la reserva
        this.cliente = cliente;
        this.hotel = hotel;
        this.habitacion = habitacion;
    }

    // Metodo para obtener el cliente de la reserva
    public Cliente getCliente() {
        return cliente;
    }

    // Metodo para obtener el hotel de la reserva
    public Hotel getHotel() {
        return hotel;
    }

    // Metodo para obtener la habitación de la reserva
    public Habitacion getHabitacion() {
        return habitacion;
    }

    // Metodo para obtener la fecha de la reserva formateada como una cadena
    public String getFechaReserva() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(fechaReserva);
    }
}
