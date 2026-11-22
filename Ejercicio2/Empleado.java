public class Empleado {
    private String nombre;
    private double sueldo;
    private static final double PORCENTAJE_MAXIMO_INCREMENTO = 0.25; // Máximo 25% autorizado por incremento

    public Empleado(String nombre, double sueldoInicial) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El nombre del empleado no puede quedar vacío.");
        }
        if (sueldoInicial < 0) {
            throw new IllegalArgumentException("Error: El sueldo inicial no puede ser negativo.");
        }
        this.nombre = nombre;
        this.sueldo = sueldoInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void aplicarIncrementoPorcentual(double porcentaje) {
        if (porcentaje <= 0) {
            throw new IllegalArgumentException("Error: El porcentaje de incremento debe ser mayor a 0%.");
        }
        if (porcentaje > PORCENTAJE_MAXIMO_INCREMENTO * 100) {
            throw new IllegalArgumentException("Error: Incremento no autorizado. El maximo permitido es del " + (PORCENTAJE_MAXIMO_INCREMENTO * 100) + "%.");
        }
        double aumento = this.sueldo * (porcentaje / 100.0);
        this.sueldo += aumento;
    }

    public void aplicarBonoAutorizado(double montoBono) {
        if (montoBono <= 0) {
            throw new IllegalArgumentException("Error: El bono debe ser mayor a $0.");
        }
        double limiteBono = this.sueldo * PORCENTAJE_MAXIMO_INCREMENTO;
        if (montoBono > limiteBono) {
            throw new IllegalArgumentException("Error: Bono no autorizado. Excede el limite permitido de $" + limiteBono + ".");
        }
        this.sueldo += montoBono;
    }
}
