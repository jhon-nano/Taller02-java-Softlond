package Ejercicio4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

// Definicion de la clase SistemaReservasHotel
public class SistemaReservasHotel {
    public Map<Hotel, List<Reserva>> reservas;
    public String[] empresasCorporativas = {
            "Autoservicio Giraldo",
            "Almacen MotoParque",
            "Ceveco",
    };

    // Constructor de la clase SistemaReservasHotel
    public SistemaReservasHotel() {
        reservas = new HashMap<>();
    }

    // Metodo para realizar una reserva de hotel
    public void realizarReserva(Cliente cliente, Hotel hotel, Habitacion numeroHabitacion) {
        // Intenta reservar una habitacion en el hotel para el cliente
        Habitacion habitacion = hotel.reservarHabitacion(cliente.getNombre(), numeroHabitacion.getNumero());
        if (habitacion != null) {
            // Crea una nueva reserva y la agrega a la lista de reservas del hotel
            Reserva reserva = new Reserva(cliente, hotel, habitacion);
            reservas.computeIfAbsent(hotel, k -> new ArrayList<>()).add(reserva);
            // Muestra un mensaje de confirmacion de la reserva
            JOptionPane.showMessageDialog(null, "Reserva realizada para " + cliente.getNombre() +
                    " en " + hotel.getNombre() +
                    " - Habitacion " + habitacion.getNumero());
        } else {
            // Muestra un mensaje de error si no hay habitaciones disponibles
            JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles en " + hotel.getNombre(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metodo para cancelar una reserva de hotel
    public void cancelarReserva(Cliente cliente, Hotel hotel, int numeroHabitacion) {
        List<Reserva> reservasHotel = reservas.get(hotel);
        if (reservasHotel != null) {
            for (Reserva reserva : reservasHotel) {
                if (reserva.getCliente().getCedula().equals(cliente.getCedula())
                        && reserva.getHabitacion().getNumero() == numeroHabitacion) {
                    // Cancela la reserva de la habitacion y la elimina de la lista de reservas
                    hotel.cancelarReserva(numeroHabitacion);
                    reservasHotel.remove(reserva);
                    return;
                }
            }
        }
    }

    // Metodo para mostrar la informacion de las reservas en un cuadro de dialogo
    public void mostrarInformacionReservas() {
        StringBuilder info = new StringBuilder();

        // Verifica si hay reservas en el sistema
        if (reservas.isEmpty()) {
            info = new StringBuilder();
            info.append("No hay reservas en el sistema.");
        } else {
            // Itera a traves de los hoteles y sus reservas asociadas
            for (Hotel hotel : reservas.keySet()) {
                info.append("Reservas en ").append(hotel.getNombre()).append(":\n");
                List<Reserva> reservasHotel = reservas.get(hotel);

                // Verifica si hay reservas en este hotel
                if (reservasHotel.isEmpty()) {
                    info.append("  No hay reservas en este hotel.\n");
                } else {
                    // Itera a traves de las reservas del hotel y muestra la informacion
                    for (Reserva reserva : reservasHotel) {
                        Cliente cliente = reserva.getCliente();
                        Habitacion habitacion = reserva.getHabitacion();
                        info.append("  Fecha: ").append(reserva.getFechaReserva())
                                .append("  Cedula: ").append(cliente.getCedula())
                                .append("  Cliente: ").append(cliente.getNombre())
                                .append("  Habitacion: ").append(habitacion.getNumero())
                                .append("\n");
                    }
                }
                info.append("\n");
            }
        }

        // Muestra la informacion de las reservas en un cuadro de dialogo
        JOptionPane.showMessageDialog(null, info.toString(), "Reservas de Hotel", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarInformacionReservasEmpresas() {
        StringBuilder info = new StringBuilder();

        // Mapa para almacenar empresas y sus reservas asociadas
        Map<String, List<Reserva>> reservasEmpresas = new HashMap<>();

        // Itera a través de las reservas y agrupa por empresas
        for (Hotel hotel : reservas.keySet()) {
            List<Reserva> reservasHotel = reservas.get(hotel);
            for (Reserva reserva : reservasHotel) {
                Cliente cliente = reserva.getCliente();
                String empresa = cliente.getEmpresa();

                // Agrega la reserva a la lista de la empresa correspondiente en el mapa
                reservasEmpresas.computeIfAbsent(empresa, k -> new ArrayList<>()).add(reserva);
            }
        }

        // Verifica si hay reservas de empresas en el sistema
        if (reservasEmpresas.isEmpty()) {
            info.append("No hay reservas de empresas en el sistema.");
        } else {
            // Itera a través de las empresas y sus reservas asociadas
            for (String empresa : reservasEmpresas.keySet()) {
                info.append("Reservas de la empresa ").append(empresa).append(":\n");
                List<Reserva> reservasEmpresa = reservasEmpresas.get(empresa);

                // Itera a través de las reservas de la empresa y muestra la información
                for (Reserva reserva : reservasEmpresa) {
                    Cliente cliente = reserva.getCliente();
                    Habitacion habitacion = reserva.getHabitacion();
                    info.append(reserva.getHotel().getNombre())
                            .append("  Habitacion: ").append(habitacion.getNumero())
                            .append("  Cliente: ").append(cliente.getNombre())
                            .append("\n");
                }
                info.append("\n");
            }
        }

        // Muestra la información de las reservas de empresas en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, info.toString(), "Reservas de Empresas", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarInformacionClientesEmpresas(List<Cliente> clientes) {
        StringBuilder info = new StringBuilder();
    
        // Mapa para almacenar empresas y sus clientes asociados
        Map<String, List<Cliente>> clientesEmpresas = new HashMap<>();
    
        // Itera a través de los clientes y agrupa por empresas
        for (Cliente cliente : clientes) {
            String empresa = cliente.getEmpresa();
    
            // Agrega el cliente a la lista de la empresa correspondiente en el mapa
            clientesEmpresas.computeIfAbsent(empresa, k -> new ArrayList<>()).add(cliente);
        }
    
        // Verifica si hay empresas en el sistema
        if (clientesEmpresas.isEmpty()) {
            info.append("No hay empresas en el sistema.");
        } else {
            // Itera a través de las empresas y sus clientes asociados
            for (String empresa : clientesEmpresas.keySet()) {
                info.append("Empresa: ").append(empresa).append("\n");
                List<Cliente> clientesEmpresa = clientesEmpresas.get(empresa);
    
                // Itera a través de los clientes de la empresa y muestra la información
                for (Cliente cliente : clientesEmpresa) {
                    info.append("  Cliente: ").append(cliente.getNombre()).append("\n");
                }
                info.append("\n");
            }
        }
    
        // Muestra la información de las empresas y clientes en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, info.toString(), "Clientes por Empresas", JOptionPane.INFORMATION_MESSAGE);
    }

}
