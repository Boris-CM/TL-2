package servicio;

import modelo.*;
import enumerativo.Genero;
import dao.implJDBC.*;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PlataformaService {

    private final Scanner sc = new Scanner(System.in);
    

    // --- OPCIÓN 1: REGISTRAR DATOS PERSONALES ---
    public void registrarDatosPersonales(Connection cx, DatosPersonalesDAOjdbc datosDAO) {
        System.out.println("\n=== Registrar Datos Personales ===");
        System.out.print("Nombres: ");
        String nombres = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("DNI: ");
        int dni = sc.nextInt(); sc.nextLine();

        if (!nombres.matches("[a-zA-ZáéíóúÁÉÍÓÚ ]+") || !apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚ ]+")) {
            System.out.println("❌ Error: nombre o apellido con caracteres inválidos.");
            return;
        }

        System.out.println("\nDatos ingresados:");
        System.out.println(nombres + " " + apellido + " - DNI: " + dni);
        System.out.print("¿Confirmar registro? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
        	datosDAO.insertar(cx, nombres, apellido, dni);
        } else {
            System.out.println("Registro cancelado.");
        }
    }

    // --- OPCIÓN 2: REGISTRAR USUARIO ---
    public void registrarUsuario(Connection cx, DatosPersonalesDAOjdbc datosDAO, UsuarioDAOjdbc usuarioDAO) {
        System.out.println("\n=== Registrar Usuario ===");

        List<DatosPersonales> personas = datosDAO.listarTodos(cx);
        if (personas.isEmpty()) {
            System.out.println("⚠️ No hay datos personales cargados. Primero registre una persona.");
            return;
        }

        System.out.println("Seleccione una persona para asociar:");
        for (int i = 0; i < personas.size(); i++) {
            System.out.println((i + 1) + ". " + personas.get(i));
        }

        System.out.print("Número: ");
        int num = sc.nextInt(); sc.nextLine();
        if (num < 1 || num > personas.size()) {
            System.out.println("❌ Número inválido.");
            return;
        }

        DatosPersonales seleccionada = personas.get(num - 1);

        System.out.print("Nombre de usuario: ");
        String nombreUsuario = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();
        if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("❌ Formato de email inválido.");
            return;
        }

        System.out.print("Contraseña: ");
        String contrasenia = sc.nextLine();

        System.out.println("\nUsuario: " + nombreUsuario + " (" + email + ")");
        System.out.print("¿Confirmar registro? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            usuarioDAO.insertar(cx, nombreUsuario, email, contrasenia, seleccionada.getId());
        } else {
            System.out.println("Registro cancelado.");
        }
    }

    // --- OPCIÓN 3: REGISTRAR PELÍCULA ---
    public void registrarPelicula(Connection cx, PeliculaDAOjdbc peliculaDAO) {
        System.out.println("\n=== Registrar Película ===");
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Director: ");
        String director = sc.nextLine();
        System.out.print("Duración (minutos): ");
        double duracion = sc.nextDouble(); sc.nextLine();

        System.out.println("Seleccione género:");
        for (Genero g : Genero.values()) {
            System.out.println("- " + g);
        }
        System.out.print("Género: ");
        String genero = sc.nextLine().toUpperCase();

        if (!existeGenero(genero)) {
            System.out.println("❌ Género inválido.");
            return;
        }

        System.out.print("Resumen (opcional): ");
        String resumen = sc.nextLine();

        System.out.println("\nPelícula: " + titulo + " (" + genero + "), Dir: " + director + ", Duración: " + duracion);
        System.out.print("¿Confirmar registro? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            peliculaDAO.insertar(cx, titulo, director, resumen, duracion, genero);
        } else {
            System.out.println("Registro cancelado.");
        }
    }

    private boolean existeGenero(String g) {
        for (Genero gen : Genero.values()) {
            if (gen.name().equalsIgnoreCase(g)) return true;
        }
        return false;
    }

    // --- OPCIÓN 4: LISTAR USUARIOS ---
    public void listarUsuarios(Connection cx, UsuarioDAOjdbc usuarioDAO) {
        System.out.println("\n=== Listado de Usuarios ===");
        List<Usuario> usuarios = usuarioDAO.listarTodos(cx);
        if (usuarios.isEmpty()) {
            System.out.println("⚠️ No hay usuarios registrados.");
            return;
        }

        System.out.println("Ordenar por: 1) NombreUsuario  2) Email");
        int op = sc.nextInt(); sc.nextLine();

        usuarios.sort((u1, u2) -> switch (op) {
            case 2 -> u1.getEmail().compareToIgnoreCase(u2.getEmail());
            default -> u1.getNombreUsuario().compareToIgnoreCase(u2.getNombreUsuario());
        });

        usuarios.forEach(System.out::println);
    }

    // --- OPCIÓN 5: LISTAR PELÍCULAS ---
    public void listarPeliculas(Connection cx, PeliculaDAOjdbc peliculaDAO) {
        System.out.println("\n=== Listado de Películas ===");
        List<Audiovisual> pelis = peliculaDAO.listarTodas(cx);
        if (pelis.isEmpty()) {
            System.out.println("⚠️ No hay películas registradas.");
            return;
        }

        System.out.println("Ordenar por: 1) Título  2) Género  3) Duración");
        int op = sc.nextInt(); sc.nextLine();

        pelis.sort((p1, p2) -> switch (op) {
            case 2 -> p1.getGenero().name().compareToIgnoreCase(p2.getGenero().name());
            case 3 -> Double.compare(p1.getDuracion(), p2.getDuracion());
            default -> p1.getTitulo().compareToIgnoreCase(p2.getTitulo());
        });

        pelis.forEach(System.out::println);
    }

    // --- OPCIÓN 6: REGISTRAR RESEÑA ---
    public void registrarResenia(Connection cx, UsuarioDAOjdbc usuarioDAO, PeliculaDAOjdbc peliculaDAO, ReseniaDAOjdbc reseniaDAO) {
        System.out.println("\n=== Registrar Reseña ===");
        System.out.print("Usuario: ");
        String nombreUsuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        Usuario u = usuarioDAO.buscarPorCredenciales(cx, nombreUsuario, pass);
        if (u == null) {
            System.out.println("❌ Credenciales inválidas.");
            return;
        }

        List<Audiovisual> pelis = peliculaDAO.listarTodas(cx);
        if (pelis.isEmpty()) {
            System.out.println("⚠️ No hay películas registradas.");
            return;
        }

        System.out.println("Seleccione una película:");
        for (int i = 0; i < pelis.size(); i++) {
            System.out.println((i + 1) + ". " + pelis.get(i));
        }

        System.out.print("Número: ");
        int num = sc.nextInt(); sc.nextLine();
        if (num < 1 || num > pelis.size()) {
            System.out.println("❌ Opción inválida.");
            return;
        }

        Audiovisual seleccionada = pelis.get(num - 1);

        System.out.print("Calificación (1 a 10): ");
        int calif = sc.nextInt(); sc.nextLine();
        System.out.print("Comentario: ");
        String comentario = sc.nextLine();

        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // Resenia r = new Resenia(0, calif, comentario, fecha, u.getId(), seleccionada.getId(), false);

        System.out.println("\nReseña: " + calif + "/10 - " + comentario);
        System.out.print("¿Confirmar registro? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            reseniaDAO.insertar(cx, calif, comentario, 0, fecha, u.getId(), seleccionada.getId());
        } else {
            System.out.println("Registro cancelado.");
        }
    }

    // --- OPCIÓN 7: APROBAR RESEÑA ---
    public void aprobarResenia(Connection cx, ReseniaDAOjdbc reseniaDAO) {
        System.out.println("\n=== Aprobar Reseñas ===");
        List<Resenia> lista = reseniaDAO.listarNoAprobadas(cx);
        if (lista.isEmpty()) {
            System.out.println("⚠️ No hay reseñas pendientes.");
            return;
        }

        for (Resenia r : lista) {
            System.out.println(r);
        }

        System.out.print("Ingrese ID de la reseña a aprobar: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("¿Confirmar aprobación? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            reseniaDAO.aprobar(cx, id);
        } else {
            System.out.println("Operación cancelada.");
        }
    }
}
