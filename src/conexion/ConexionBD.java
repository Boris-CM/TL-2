package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:plataforma.db";

    private static ConexionBD instancia; // instancia única
    private Connection cx; // conexión asociada

    // Constructor privado para evitar instanciación externa
    private ConexionBD() {
        try {
            Class.forName(DRIVER);
            cx = DriverManager.getConnection(URL);
            System.out.println("✅ Conexión establecida correctamente.");
        } catch (Exception e) {
            System.err.println("❌ Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    // Método público estático para obtener la instancia única
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    // Retorna la conexión activa
    public Connection getConexion() {
        return cx;
    }

    // Cierra la conexión (si existe)
    public void desconectar() {
        try {
            if (cx != null && !cx.isClosed()) {
                cx.close();
                System.out.println("🔒 Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearTablas() {
        try (Statement stmt = cx.createStatement()) {

            String sqlDatosPersonales = """
                CREATE TABLE IF NOT EXISTS DATOS_PERSONALES (
                    ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    NOMBRES TEXT(100) NOT NULL,
                    APELLIDO TEXT(100) NOT NULL,
                    DNI INTEGER NOT NULL UNIQUE
                );
            """;

            String sqlUsuario = """
                CREATE TABLE IF NOT EXISTS USUARIO (
                    ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    NOMBRE_USUARIO TEXT NOT NULL,
                    EMAIL TEXT NOT NULL,
                    CONTRASENIA TEXT NOT NULL,
                    ID_DATOS_PERSONALES INTEGER NOT NULL,
                    FOREIGN KEY(ID_DATOS_PERSONALES) REFERENCES DATOS_PERSONALES(ID)
                );
            """;

            String sqlPelicula = """
                CREATE TABLE IF NOT EXISTS PELICULA (
                    ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    GENERO TEXT(1) NOT NULL,
                    TITULO TEXT(100) NOT NULL,
                    RESUMEN TEXT(500),
                    DIRECTOR TEXT(100) NOT NULL,
                    DURACION REAL NOT NULL
                );
            """;

            String sqlResenia = """
                CREATE TABLE IF NOT EXISTS RESENIA (
                    ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    CALIFICACION INTEGER NOT NULL,
                    COMENTARIO TEXT(500),
                    APROBADO INTEGER DEFAULT (1) NOT NULL,
                    FECHA_HORA TEXT NOT NULL,
                    ID_USUARIO INTEGER NOT NULL,
                    ID_PELICULA INTEGER NOT NULL,
                    FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID),
                    FOREIGN KEY(ID_PELICULA) REFERENCES PELICULA(ID)
                );
            """;

            stmt.execute(sqlDatosPersonales);
            stmt.execute(sqlUsuario);
            stmt.execute(sqlPelicula);
            stmt.execute(sqlResenia);

            System.out.println("✅ Tablas creadas correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error creando tablas: " + e.getMessage());
        }
    }
}
