package Practica12.Banco;

import java.util.ArrayList;

public class Cuenta {

    private String titular;
    private String numeroBanco;
    private double saldo;
    private ArrayList<Movimientos> historial;

    public Cuenta(String titular, String numeroBanco, double saldo) {
        this.titular = titular;
        this.numeroBanco = numeroBanco;
        this.saldo = saldo >= 0 ? saldo : 0;
        this.historial = new ArrayList<>();
    }

    public String getNumero() {

        return numeroBanco;
    }

    public String getTitular() {

        return titular;
    }

    public double getSaldo() {

        return saldo;
    }

    public ArrayList<Movimientos> getHistorial() {

        return new ArrayList<>(historial);
    }

    private void registrarMovimiento(String operacion, double monto) {
        historial.add(new Movimientos(operacion, saldo, monto));
        System.out.println(operacion + " de $" + monto + ", el saldo resultante es: $" + saldo);
    }

    public boolean depositarCuenta(double monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido, no se puede depositar");  
            return false;
        }
        saldo += monto;
        registrarMovimiento("Depósito", monto);
        return true;
    }

    public boolean retirarCuenta(double monto) {
        if (monto <= 0 || monto > saldo) {
            System.out.println("Monto invalido, no se puede retirar");  
            return false;
        }
        saldo -= monto;
        registrarMovimiento("Retiro", monto);
        return true;
    }

    public boolean transferirCuenta(Cuenta destino, double monto) {

        if ( monto <= 0 || monto > saldo) {
            System.out.println("Monto invalido, no se puede transferir");  
            return false;
        }
        if(destino == null || destino == this ){
            System.out.println("Error al buscar la cuenta");  
            return false;
        }
        
        saldo -= monto;
        registrarMovimiento("Transferencia enviada a " + destino.numeroBanco, monto);
        destino.recibirTransferencia(monto, this.numeroBanco);
        return true;
    }

    
    void recibirTransferencia(double monto, String numeroOrigen) {
        saldo += monto;
        registrarMovimiento("Transferencia recibida de " + numeroOrigen, monto);
    }

    public void mostrarHistorial() {
        System.out.println("Historial de " + titular + " "  + numeroBanco + ":");
        for (Movimientos m : historial) {
            System.out.println("  " + m);
        }
    }
}
