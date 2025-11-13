package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    
}
