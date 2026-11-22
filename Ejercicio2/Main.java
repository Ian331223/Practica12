public class Main04 {
    public static void main(String[] args) {
        try {
            Empleado empleado = new Empleado("Laura Mendez", 20000.0);
            System.out.println("Empleado: " + empleado.getNombre() + " | Sueldo inicial: $" + empleado.getSueldo());

            empleado.aplicarIncrementoPorcentual(10.0);
            System.out.println("Sueldo tras incremento autorizado del 10%: $" + empleado.getSueldo());

            empleado.aplicarBonoAutorizado(2000.0);
            System.out.println("Sueldo tras bono autorizado de $2,000: $" + empleado.getSueldo());

            System.out.println("\nProbando incremento no autorizado (40%)");
            empleado.aplicarIncrementoPorcentual(40.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProbando bono que excede el limite autorizado");
        try {
            Empleado empleado2 = new Empleado("Jorge Ramírez", 10000.0);
            empleado2.aplicarBonoAutorizado(5000.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
