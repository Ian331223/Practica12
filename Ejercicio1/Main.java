public class Main03 {
    public static void main(String[] args) {
        try {
            Sueldo sueldoValido = new Sueldo(15000.0);
            System.out.println("Sueldo registrado correctamente: $" + sueldoValido.getMonto());

            sueldoValido.setMonto(17500.0);
            System.out.println("Sueldo actualizado correctamente: $" + sueldoValido.getMonto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProbando asignacion de sueldo negativo");

        try {
            Sueldo sueldoInvalido = new Sueldo(-2500.0);
            System.out.println("Sueldo registrado: $" + sueldoInvalido.getMonto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
