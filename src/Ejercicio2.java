import javax.swing.JOptionPane;

import Ejercicio2.ConversorMonedas;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Definir los tipos de cambio
        double tipoCambioDolarEuro = 0.85;
        double tipoCambioPesoDolar = 20.0;

        // Crear una instancia del ConversorMonedas con los tipos de cambio definidos
        ConversorMonedas conversor = new ConversorMonedas(tipoCambioDolarEuro, tipoCambioPesoDolar);

        // Array de monedas para mostrar en los cuadros de dialogo
        String[] monedas = { "Dolares", "Euros", "Pesos" };

        // Bucle principal del programa
        while (true) {
            // Obtener la moneda de origen seleccionada por el usuario
            String monedaOrigen = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione la moneda de origen:",
                    "Conversor de Monedas",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    monedas,
                    monedas[0]);

            if (monedaOrigen == null) {
                System.exit(0);
            }

            // Obtener la moneda de destino seleccionada por el usuario
            String monedaDestino = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione la moneda de destino:",
                    "Conversor de Monedas",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    monedas,
                    monedas[0]);

            if (monedaDestino == null) {
                System.exit(0);
            }

            // Obtener la cantidad a convertir
            double cantidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad:"));

            // Realizar la conversion utilizando el objeto ConversorMonedas
            double resultado = conversor.convertir(cantidad, monedaOrigen, monedaDestino);

            // Mostrar el resultado de la conversion en un cuadro de dialogo
            JOptionPane.showMessageDialog(
                    null,
                    cantidad + " " + monedaOrigen + " son " + resultado + " " + monedaDestino + ".",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
