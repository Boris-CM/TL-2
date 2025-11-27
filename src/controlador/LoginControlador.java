package controlador;

import javax.swing.JOptionPane;

import dao.implementacion.UsuarioDAOjdbc;
import modelo.Usuario;
import vista.LoginVista;
import vista.PlataformaStreamingVista;

public class LoginControlador {
	
	private LoginVista vista;
    private UsuarioDAOjdbc usuarioDAO;

    public LoginControlador(PlataformaStreamingVista mainWindow, UsuarioDAOjdbc usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
        this.vista = new LoginVista();

        mainWindow.agregarVista("LOGIN", vista);

        configurarEventos(mainWindow);
    }

    private void configurarEventos(PlataformaStreamingVista mainWindow) {
        vista.getBtnIngresar().addActionListener(e -> {
            String email = vista.getCampoEmail().getText();
            String contrasenia = new String(vista.getCampoContrasenia().getPassword());
            
            if (email.isEmpty() || contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(mainWindow, "Debe completar Email y Contraseña");
                return;
            }

            Usuario usuario = usuarioDAO.buscarPorCredenciales(email, contrasenia);
            if(usuario != null) {
                JOptionPane.showMessageDialog(mainWindow, "Login correcto");
            } else {
            	JOptionPane.showMessageDialog(mainWindow,"Credenciales incorrectas");
            }
        });

        vista.getBtnRegistrar().addActionListener(e -> {
        	vista.limpiarCampos();
        	mainWindow.mostrar("REGISTRO");
        });
    }

}
