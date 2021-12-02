package tp;

import javax.swing.*;

    public class CuentaBancaria {

        //ATRIBUTOS
         String nombreCliente;
         String dniCliente;
         double saldo = 500;
         double ultimoMovimiento;
         boolean deposito = false;
         boolean retiro = false;

        //CONSTRUCTORES
        public CuentaBancaria(String nombreCliente, String dniCliente) {
            this.nombreCliente = nombreCliente;
            this.dniCliente = dniCliente;
        }

        public CuentaBancaria(String nombreCliente, String dniCliente, double saldo) {
            this.nombreCliente = nombreCliente;
            this.dniCliente = dniCliente;
            this.saldo = saldo;
        }

        //METODOS
        public void depositar(double cantidad) {
            saldo += cantidad;
            ultimoMovimiento = cantidad;
            JOptionPane.showMessageDialog(null,"Su deposito fue de : $"+cantidad+"\nSu saldo actual es de : $"+saldo,nombreCliente,JOptionPane.PLAIN_MESSAGE);
        }

        public void retirar(double cantidad) {
            if (saldo >= cantidad) {
                saldo -= cantidad;
                ultimoMovimiento = cantidad;
                JOptionPane.showMessageDialog(null,"Su extraccion fue de : $"+cantidad+"\nSu saldo actual es de : $"+saldo,nombreCliente,JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,"Imposible realizar la operacion, \n intentelo de nuevo", "Error",JOptionPane.PLAIN_MESSAGE);
            }
        }
        public void consultarUltimoMovimiento() {
            if (deposito) {
                JOptionPane.showMessageDialog(null, "El importe del depósito fue de: $ " + ultimoMovimiento, "Último movimiento - Depósito", JOptionPane.PLAIN_MESSAGE);
            } else if (retiro) {
                JOptionPane.showMessageDialog(null, "El importe de la extracción fue de: $ " + ultimoMovimiento, "Último movimiento - Extraccion", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se han realizado transacciones", "Último movimiento", JOptionPane.PLAIN_MESSAGE);
            }
        }

        public void mostrarMenu() {

            String menu;

            do {
                menu = JOptionPane.showInputDialog(null,
                        "Bienvenido \n" +  nombreCliente + "\n" +
                                "\nIngrese su opción: \n(Solamente la letra)" + "\n" +
                                "\n- A: Consultar saldo." +
                                "\n- B: Depositar." +
                                "\n- C: Retirar." +
                                "\n- D: Consultar último movimiento." +
                                "\n- E: Salir." + "\n" , "Menú",
                                    JOptionPane.PLAIN_MESSAGE);

                if (menu.equalsIgnoreCase("A")) {

                    if (saldo < 0) {
                        JOptionPane.showMessageDialog(null, "Su saldo actual es negativo : $ " + saldo, nombreCliente, JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Su saldo actual es : $" + saldo, nombreCliente, JOptionPane.PLAIN_MESSAGE);
                    }

                } else if (menu.equalsIgnoreCase("B")) {

                    double cantidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el importe a depositar", "Menú", JOptionPane.PLAIN_MESSAGE));
                    depositar(cantidad);

                    deposito = true;
                    retiro = false;

                } else if (menu.equalsIgnoreCase("C")) {

                    double cantidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el importe a retirar", "Menú", JOptionPane.PLAIN_MESSAGE));
                    retirar(cantidad);

                    retiro = true;
                    deposito = false;

                } else if (menu.equalsIgnoreCase("D")) {
                    consultarUltimoMovimiento();
                } else if (menu.equalsIgnoreCase("E")) {
                    JOptionPane.showMessageDialog(null, "Adios " + nombreCliente + ", gracias por elegirnos", "Menú", JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (!menu.equalsIgnoreCase("E"));
        }
    }

