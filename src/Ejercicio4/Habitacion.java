package Ejercicio4;

// Definicion de la clase Habitacion
public class Habitacion {
    private int numero;
    private String ocupante;

    // Constructor de la clase Habitacion
    public Habitacion(int numero) {
        this.numero = numero;
        this.ocupante = ""; // Habitacion inicialmente no ocupada
    }

    // Metodo para obtener el numero de habitacion
    public int getNumero() {
        return numero;
    }

    // Metodo para obtener el nombre del ocupante de la habitacion
    public String getOcupante() {
        return ocupante;
    }

    // Metodo para reservar la habitacion con un ocupante especifico
    public void reservar(String ocupante) {
        this.ocupante = ocupante;
    }

    // Metodo para cancelar la reserva de la habitacion
    public void cancelarReserva() {
        this.ocupante = ""; // Habitacion se marca como no ocupada
    }

    // Sobrescritura del metodo toString() para mostrar el numero de habitacion en representaciones de cadena
    @Override
    public String toString() {
        return String.valueOf(numero); // Convertir el numero de habitacion a una cadena
    }
}
