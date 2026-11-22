public class Sueldo {
    private double monto;

    public Sueldo(double montoInicial) {
        setMonto(montoInicial);
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("Error: El sueldo no puede ser negativo.");
        }
        this.monto = monto;
    }
}
