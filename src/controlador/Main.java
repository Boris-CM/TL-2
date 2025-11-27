package controlador;

import java.sql.Connection;

import conexion.ConexionBD;
import dao.FactoryDAO;
import tablas.TablasBD;

public class Main {

	public static void main(String[] args) {

        // Inicializar BD
        Connection cx = ConexionBD.getInstancia().getConexion();
        TablasBD tablas = new TablasBD();
        tablas.crearTablas(cx);

        FactoryDAO factory = new FactoryDAO();

        // Crear controlador principal
        PlataformaStreamingControlador controller = new PlataformaStreamingControlador(factory);
        controller.iniciar();

        // Shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(
                () -> ConexionBD.getInstancia().desconectar()
        ));
    }

}
