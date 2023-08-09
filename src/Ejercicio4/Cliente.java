package Ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Definicion de la clase Cliente
public class Cliente {

    private String empresa;

    private String cedula;
    private String nombre;

    // Constructor de la clase Cliente
    public Cliente(String nombre, String cedula, String empresa) {
        this.empresa = empresa;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    // Metodo para obtener el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Metodo para obtener la cedula del cliente
    public String getCedula() {
        return cedula;
    }

    // Metodo para obtener la empresa del cliente
    public String getEmpresa() {
        return empresa;
    }

    // Metodo para obtener la lista de reservas de un cliente en un mapa de reservas
    public List<Reserva> getReservas(Map<Hotel, List<Reserva>> reservas, Cliente cliente) {
        List<Reserva> reservasCliente = new ArrayList<>();
        for (Hotel hotel : reservas.keySet()) {
            List<Reserva> reservasEnHotel = reservas.get(hotel);
            for (Reserva reserva : reservasEnHotel) {
                if (reserva.getCliente().equals(cliente)) {
                    reservasCliente.add(reserva);
                }
            }
        }
        return reservasCliente;
    }

    // Sobrescritura del metodo toString() para mostrar el nombre del cliente
    @Override
    public String toString() {
        return nombre; // Mostrar el nombre del cliente en representaciones de cadena
    }
}
