package main;
import conexion.ConexionBD;
import dao.FactoryDAO;
import servicio.PlataformaService;
import tablas.TablasBD;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Connection cx = ConexionBD.getInstancia().getConexion();
		TablasBD tablas = new TablasBD();
		FactoryDAO factory = new FactoryDAO();
		PlataformaService servicio = new PlataformaService();
		Scanner sc = new Scanner(System.in);
		int opcion;

		try {
			tablas.crearTablas(cx);
			// --- MENÚ PRINCIPAL ---
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
	
				switch (opcion) {
				case 1 -> servicio.registrarDatosPersonales(cx, factory.getDatosDAO());
				case 2 -> servicio.registrarUsuario(cx, factory.getDatosDAO(), factory.getUsuarioDAO());
				case 3 -> servicio.registrarPelicula(cx, factory.getPeliculaDAO());
				case 4 -> servicio.listarUsuarios(cx, factory.getUsuarioDAO());
				case 5 -> servicio.listarPeliculas(cx, factory.getPeliculaDAO());
				case 6 -> servicio.registrarResenia(cx, factory.getUsuarioDAO(), factory.getPeliculaDAO(),
						factory.getReseniaDAO());
				case 7 -> servicio.aprobarResenia(cx, factory.getReseniaDAO());
				case 0 -> System.out.println("Saliendo...");
				default -> System.out.println("⚠️ Opción inválida.");
				}
			} while (opcion != 0);
		} catch(Exception e) {
			System.out.println("Error: "+ e);
		} finally {
			sc.close();
			ConexionBD.getInstancia().desconectar();
			System.out.println("Fin del programa.");
		}

		
	}
}
