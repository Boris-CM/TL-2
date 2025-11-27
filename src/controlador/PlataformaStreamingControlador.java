package controlador;

import java.awt.Font;

import javax.swing.UIManager;

import dao.FactoryDAO;
import vista.PlataformaStreamingVista;

public class PlataformaStreamingControlador {
	
	private PlataformaStreamingVista vista;
    private FactoryDAO factory;

    private LoginControlador loginController;
    private RegistroControlador registroController;

    public PlataformaStreamingControlador(FactoryDAO factory) {
        this.factory = factory;
        cargarFuenteRoboto();
    }

    public void iniciar() {
        vista = new PlataformaStreamingVista();

        // Controladores de pantallas
        loginController = new LoginControlador(vista, factory.getUsuarioDAO());
        registroController = new RegistroControlador(vista, factory.getDatosDAO(), factory.getUsuarioDAO());

        // Mostrar login al inicio
        mostrarLogin();

        vista.setVisible(true);
    }

    public void mostrarLogin() {
        vista.mostrar("LOGIN");
    }

    public void mostrarRegistro() {
        vista.mostrar("REGISTRO");
    }
    
    private void cargarFuenteRoboto() {
        try {
            Font roboto = Font.createFont(
                    Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/fuente/Roboto-Regular.ttf")
            ).deriveFont(14f);

            UIManager.put("Button.font", roboto);
            UIManager.put("Label.font", roboto);
            UIManager.put("TextField.font", roboto);
            UIManager.put("PasswordField.font", roboto);
            UIManager.put("TextArea.font", roboto);
            UIManager.put("ComboBox.font", roboto);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
