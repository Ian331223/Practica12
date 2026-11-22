package Practica12.Main;

import Practica12.Banco.Cuenta;
import Practica12.Servicios.ServciosBanco;

public class Main {

    public static void main(String[] args) {
        ServciosBanco banco = new ServciosBanco();
        Cuenta c1 = banco.crearCuenta("Chocoperro", 500);
        Cuenta c2 = banco.crearCuenta("Ana", 100);          

        System.out.println(c1.getTitular() + ": $" + c1.getSaldo());
        System.out.println(c2.getTitular() + ": $" + c2.getSaldo());
        System.out.println();

        
        c1.depositarCuenta(200);
        c1.retirarCuenta(400);
        c1.transferirCuenta(c2, 200);
        
        System.out.println(c1.getTitular() + ": $" + c1.getSaldo());
        System.out.println(c2.getTitular() + ": $" + c2.getSaldo());
        System.out.println();
        c1.mostrarHistorial();
        c2.mostrarHistorial();
    }
}
