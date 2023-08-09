package Ejercicio2;

public class ConversorMonedas {
    private double tipoCambioDolarEuro;
    private double tipoCambioPesoDolar;

    // Constructor que recibe los tipos de cambio
    public ConversorMonedas(double tipoCambioDolarEuro, double tipoCambioPesoDolar) {
        this.tipoCambioDolarEuro = tipoCambioDolarEuro;
        this.tipoCambioPesoDolar = tipoCambioPesoDolar;
    }

    // Metodo para convertir una cantidad de una moneda a otra
    public double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
        if (monedaOrigen.equalsIgnoreCase("dolares") && monedaDestino.equalsIgnoreCase("euros")) {
            return cantidad * tipoCambioDolarEuro;  // Convertir de dolares a euros
        } else if (monedaOrigen.equalsIgnoreCase("dolares") && monedaDestino.equalsIgnoreCase("pesos")) {
            return cantidad * tipoCambioPesoDolar;  // Convertir de dolares a pesos
        } else if (monedaOrigen.equalsIgnoreCase("euros") && monedaDestino.equalsIgnoreCase("dolares")) {
            return cantidad / tipoCambioDolarEuro;  // Convertir de euros a dolares
        } else if (monedaOrigen.equalsIgnoreCase("euros") && monedaDestino.equalsIgnoreCase("pesos")) {
            // Convertir de euros a pesos (primero a dolares y luego a pesos)
            return (cantidad * tipoCambioDolarEuro) * tipoCambioPesoDolar;
        } else if (monedaOrigen.equalsIgnoreCase("pesos") && monedaDestino.equalsIgnoreCase("dolares")) {
            return cantidad / tipoCambioPesoDolar;  // Convertir de pesos a dolares
        } else if (monedaOrigen.equalsIgnoreCase("pesos") && monedaDestino.equalsIgnoreCase("euros")) {
            // Convertir de pesos a euros (primero a dolares y luego a euros)
            return (cantidad / tipoCambioPesoDolar) / tipoCambioDolarEuro;
        } else {
            // Manejar casos de conversion no soportada
            throw new IllegalArgumentException("Conversion no soportada");
        }
    }
}
