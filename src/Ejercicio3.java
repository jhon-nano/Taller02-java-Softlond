import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Ejercicio3.Calculadora;

/**
 * Clase principal que implementa una calculadora simple utilizando la clase Calculadora.
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        // Obtener el primer numero
        String inputNumero1 = JOptionPane.showInputDialog("Ingrese el primer numero:");

        if (inputNumero1 == null) {
            JOptionPane.showMessageDialog(null, "Operacion cancelada", "Calculadora", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        double numero1 = Double.parseDouble(inputNumero1);

        String[] operaciones = { "+", "-", "*", "/" };

        // Seleccionar la operacion deseada
        String operacion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la operacion:",
                "Operaciones",
                JOptionPane.PLAIN_MESSAGE,
                null,
                operaciones,
                operaciones[0]);

        if (operacion == null) {
            JOptionPane.showMessageDialog(null, "Operacion cancelada", "Calculadora", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        // Obtener el segundo numero
        String inputNumero2 = JOptionPane.showInputDialog("Ingrese el segundo numero:");
        if (inputNumero2 == null) {
            JOptionPane.showMessageDialog(null, "Operacion cancelada", "Calculadora", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        double numero2 = Double.parseDouble(inputNumero2);

        double resultado = 0;

        // Realizar la operacion y mostrar el resultado
        switch (operacion) {
            case "+":
                resultado = calculadora.sumar(numero1, numero2);
                break;
            case "-":
                resultado = calculadora.restar(numero1, numero2);
                break;
            case "*":
                resultado = calculadora.multiplicar(numero1, numero2);
                break;
            case "/":
                resultado = calculadora.dividir(numero1, numero2);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Operacion no valida");
                System.exit(0);
        }

        // Mostrar el resultado en una ventana de dialogo
        JTextField textField = new JTextField(15);
        textField.setEditable(false);

        JPanel panel = new JPanel();
        panel.add(textField);

        textField.setText(numero1 + " " + operacion + " " + numero2 + " = " + resultado);

        JOptionPane.showMessageDialog(null, panel, "Calculadora", JOptionPane.PLAIN_MESSAGE);
    }
}
