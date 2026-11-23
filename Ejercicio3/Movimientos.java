ackage Practica12.Banco;

import java.time.LocalDateTime;

public class Movimientos {

    private final String operacion;
    private final double saldoRestante;
    private final double monto;
    private final LocalDateTime fecha;



    Movimientos(String operacion, double saldoRestante, double monto){

        this.operacion= operacion;
        this.monto = monto;
        this.saldoRestante=saldoRestante;
        this.fecha= LocalDateTime.now();

    }

    public String getOperacion(){

        return operacion;

    }


    public double getMonto(){
        return monto;
    }

    public double getSaldoRestante(){

        return saldoRestante;
    }
    
    public LocalDateTime getFecha(){

        return fecha;
    }


    @Override 
    public String toString(){

        return fecha +"|" +  operacion + " $" + monto + " " +"saldo: $" + saldoRestante;
    }
}
