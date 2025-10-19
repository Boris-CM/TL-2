package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
    private static final String URL = "jdbc:sqlite:plataforma.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void crearTablas() {
        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {

            String sqlDatosPersonales = """
                CREATE TABLE IF NOT EXISTS DATOS_PERSONALES (
                    ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    NOMBRES TEXT NOT NULL,
                    APELLIDO TEXT NOT NULL,
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
                    GENERO TEXT NOT NULL,
                    TITULO TEXT NOT NULL,
                    RESUMEN TEXT,
                    DIRECTOR TEXT NOT NULL,
                    DURACION REAL NOT NULL
                );
            """;

            String sqlResenia = """
                CREATE TABLE IF NOT EXISTS RESENIA (
                    ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    CALIFICACION INTEGER NOT NULL,
                    COMENTARIO TEXT,
                    APROBADO INTEGER DEFAULT 0,
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

        } catch (SQLException e) {
            System.out.println("Error creando tablas: " + e.getMessage());
        }
    }
}
