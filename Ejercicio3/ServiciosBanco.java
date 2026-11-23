package Practica12.Servicios;

import java.util.ArrayList;
import Practica12.Banco.Cuenta;

public class ServciosBanco {

    private ArrayList<Cuenta> cuentas;
    private int contador;

    public ServciosBanco() {
        cuentas = new ArrayList<>();
        contador = 1;
    }

    public Cuenta crearCuenta(String titular, double saldoInicial) {
        String numero = String.format("%02d", contador++);
        Cuenta cuenta = new Cuenta(titular, numero, saldoInicial);
        cuentas.add(cuenta);
        return cuenta;
    }

    public Cuenta buscar(String numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    public boolean depositar(String numero, double monto) {
        Cuenta c = buscar(numero);
        return c != null && c.depositarCuenta(monto);
    }

    public boolean retirar(String numero, double monto) {
        Cuenta c = buscar(numero);
        return c != null && c.retirarCuenta(monto);
    }

    public boolean transferir(String origen, String destino, double monto) {
        Cuenta o = buscar(origen);
        Cuenta d = buscar(destino);
        return o != null && o.transferirCuenta(d, monto);
    }
}
