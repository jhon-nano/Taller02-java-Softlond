import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Ejercicio4.SistemaReservasHotel;
import Ejercicio4.Hotel;
import Ejercicio4.Reserva;
import Ejercicio4.Cliente;
import Ejercicio4.Habitacion;

// Definicion de la clase principal Ejercicio4
public class Ejercicio4 {
    public static void main(String[] args) {

        // Creacion de una instancia del sistema de reservas
        SistemaReservasHotel sistema = new SistemaReservasHotel();

        // Creacion de una lista de clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Juan Perez", "12345678", sistema.empresasCorporativas[0]));
        clientes.add(new Cliente("Maria Rodriguez", "87654321", sistema.empresasCorporativas[1]));

        // Creacion de una lista de hoteles
        List<Hotel> hoteles = new ArrayList<>();
        hoteles.add(new Hotel("Hotel Plazazul", 5));
        hoteles.add(new Hotel("Hotel Chamizal", 10));

        // Bucle principal del programa
        while (true) {
            // Mostrar un cuadro de dialogo con las opciones disponibles
            String[] opciones = {
                    "Realizar Reserva",
                    "Cancelar Reserva",
                    "Mostrar Informes",
                    "Nuevo",
                    "Salir"
            };

            StringBuilder empresasTexto = new StringBuilder("[");

            for (int i = 0; i < sistema.empresasCorporativas.length; i++) {
                empresasTexto.append(sistema.empresasCorporativas[i]);

                if (i < sistema.empresasCorporativas.length - 1) {
                    empresasTexto.append(", ");
                }
            }

            empresasTexto.append("]");

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "<html>Reservas Hoteleras:<br><pre>Empresas: " + empresasTexto + "<br>" +
                            +hoteles.size() + " Hoteles: "
                            + hoteles.toString() + "<br>"
                            + clientes.size() + " Clientes Corporativos: "
                            + clientes.toString() +
                            "</pre><br>Seleccione una opcion:</html>",
                    "Sistema de Reservas de Hotel",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (seleccion) {
                case 0: // Realizar Reserva
                    // Seleccionar un cliente
                    Cliente clienteSeleccionado = (Cliente) JOptionPane.showInputDialog(
                            null,
                            "Seleccione el cliente:",
                            "Realizar Reserva",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            clientes.toArray(),
                            null);

                    if (clienteSeleccionado == null) {
                        break; // Usuario cancelo
                    }

                    // Seleccionar un hotel
                    Hotel hotelSeleccionado = (Hotel) JOptionPane.showInputDialog(
                            null,
                            "Seleccione el hotel:",
                            "Realizar Reserva",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            hoteles.toArray(),
                            null);

                    if (hotelSeleccionado == null) {
                        break; // Usuario cancelo
                    }

                    // Obtener las habitaciones disponibles en el hotel
                    List<Habitacion> habitacionesDisponibles = hotelSeleccionado.getHabitacionesDisponibles();

                    if (habitacionesDisponibles.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "No hay habitaciones disponibles en " + hotelSeleccionado.getNombre(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    // Seleccionar una habitacion
                    Habitacion habitacionSeleccionada = (Habitacion) JOptionPane.showInputDialog(
                            null,
                            "Seleccione la habitacion:",
                            "Realizar Reserva",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            habitacionesDisponibles.toArray(),
                            habitacionesDisponibles.get(0));

                    if (habitacionSeleccionada == null) {
                        break; // Usuario cancelo
                    }

                    // Realizar la reserva y mostrar un mensaje de confirmacion
                    sistema.realizarReserva(clienteSeleccionado, hotelSeleccionado, habitacionSeleccionada);
                    JOptionPane.showMessageDialog(null, "Reserva realizada exitosamente.");
                    break;

                case 1: // Cancelar Reserva
                    // Seleccionar un cliente para cancelar la reserva
                    Cliente clienteSeleccionadoCancelar = (Cliente) JOptionPane.showInputDialog(
                            null,
                            "Seleccione el cliente:",
                            "Cancelar Reserva",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            clientes.toArray(),
                            null);

                    if (clienteSeleccionadoCancelar == null) {
                        break; // Usuario cancelo
                    }

                    // Obtener las reservas del cliente seleccionado
                    List<Reserva> reservasCliente = clienteSeleccionadoCancelar.getReservas(sistema.reservas,
                            clienteSeleccionadoCancelar);

                    if (reservasCliente.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El cliente no tiene reservas.", "Informacion",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                    // Crear un JComboBox con las opciones de reserva para cancelar
                    String[] opcionesReservas = new String[reservasCliente.size()];
                    for (int i = 0; i < reservasCliente.size(); i++) {
                        Reserva reserva = reservasCliente.get(i);
                        opcionesReservas[i] = "Hotel: " + reserva.getHotel().getNombre() + ", Habitacion: "
                                + reserva.getHabitacion().getNumero();
                    }

                    JComboBox<String> comboBoxReservas = new JComboBox<>(opcionesReservas);
                    int result = JOptionPane.showConfirmDialog(
                            null,
                            comboBoxReservas,
                            "Seleccione la reserva a cancelar:",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        int seleccionReserva = comboBoxReservas.getSelectedIndex();
                        Reserva reservaCancelar = reservasCliente.get(seleccionReserva);
                        // Cancelar la reserva y mostrar un mensaje de confirmacion
                        sistema.cancelarReserva(clienteSeleccionadoCancelar, reservaCancelar.getHotel(),
                                reservaCancelar.getHabitacion().getNumero());
                        JOptionPane.showMessageDialog(null, "Reserva cancelada exitosamente.");
                    }
                    break;

                case 2: // Mostrar Reservas

                    String[] opcionesMostrar = {
                            "Hoteles",
                            "Empresas",
                            "Clientes",
                            "Volver"
                    };

                    int seleccionMostrar = JOptionPane.showOptionDialog(
                            null,
                            "Que deseas ver?",
                            "Informacion",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcionesMostrar,
                            opcionesMostrar[0]);
                    // Mostrar la informacion de las reservas en un cuadro de dialogo

                    switch (seleccionMostrar) {
                        case 0: // Crear Cliente
                            sistema.mostrarInformacionReservas();
                            break;
                        case 1: // Crear Cliente
                            sistema.mostrarInformacionReservasEmpresas();
                            break;
                        case 2: // Crear Cliente
                            sistema.mostrarInformacionClientesEmpresas(clientes);
                            break;
                        case 3: // Volver
                            break;
                    }

                    break;

                case 3: // Crear Cliente o Hotel
                    // Mostrar un submenu para crear un cliente o un hotel
                    String[] opcionesCrear = {
                            "Cliente",
                            "Hotel",
                            "Volver"
                    };

                    int seleccionCrear = JOptionPane.showOptionDialog(
                            null,
                            "Que deseas crear?",
                            "Crear Cliente o Hotel",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcionesCrear,
                            opcionesCrear[0]);

                    switch (seleccionCrear) {
                        case 0: // Crear Cliente
                            String nombreNuevoCliente = JOptionPane
                                    .showInputDialog("Ingrese el nombre del nuevo cliente:");
                            if (nombreNuevoCliente != null && !nombreNuevoCliente.isEmpty()) {
                                String cedulaNuevoCliente = JOptionPane
                                        .showInputDialog("Ingrese la cedula del nuevo cliente:");
                                if (cedulaNuevoCliente != null && !cedulaNuevoCliente.isEmpty()) {

                                    int seleccionEmpresa = JOptionPane.showOptionDialog(
                                            null,
                                            "Selecciona una empresa?",
                                            "Empresas Corporativas",
                                            JOptionPane.DEFAULT_OPTION,
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,
                                            sistema.empresasCorporativas,
                                            sistema.empresasCorporativas[0]);

                                    clientes.add(new Cliente(nombreNuevoCliente, cedulaNuevoCliente,
                                            sistema.empresasCorporativas[seleccionEmpresa]));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Debe ingresar una cedula valida.", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre valido.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case 1: // Crear Hotel
                            String nombreNuevoHotel = JOptionPane.showInputDialog("Ingrese el nombre del nuevo hotel:");
                            if (nombreNuevoHotel != null && !nombreNuevoHotel.isEmpty()) {
                                String capacidadString = JOptionPane
                                        .showInputDialog("Ingrese la capacidad del nuevo hotel:");
                                try {
                                    int capacidadNuevoHotel = Integer.parseInt(capacidadString);
                                    hoteles.add(new Hotel(nombreNuevoHotel, capacidadNuevoHotel));
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Debe ingresar una capacidad valida.", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre valido.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case 2: // Volver
                            break;

                    }
                    break;

                case 4: // Salir
                    // Salir del programa
                    System.exit(0);
            }
        }
    }
}
