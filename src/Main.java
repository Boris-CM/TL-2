import dao.ConexionBD;
import servicio.PlataformaService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConexionBD.crearTablas();
        PlataformaService servicio = new PlataformaService();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Plataforma Streaming ===");
            System.out.println("1. Registrar Datos Personales");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Registrar Película");
            System.out.println("4. Listar Usuarios");
            System.out.println("5. Listar Películas");
            System.out.println("6. Registrar Reseña");
            System.out.println("7. Aprobar Reseña");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            servicio.ejecutarOpcion(opcion);
        } while (opcion != 0);

        sc.close();
        System.out.println("Fin del programa.");
    }
}
