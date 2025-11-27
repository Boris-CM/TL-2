package controlador;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import dao.implementacion.DatosPersonalesDAOjdbc;
import dao.implementacion.UsuarioDAOjdbc;
import modelo.DatosPersonales;
import vista.PlataformaStreamingVista;
import vista.RegistroVista;

public class RegistroControlador {
	private RegistroVista vista;
    private DatosPersonalesDAOjdbc datosDAO;
    private UsuarioDAOjdbc usuarioDAO;

    public RegistroControlador(PlataformaStreamingVista mainWindow, DatosPersonalesDAOjdbc datosDAO, UsuarioDAOjdbc usuarioDAO) {
        this.datosDAO = datosDAO;
        this.usuarioDAO = usuarioDAO;

        this.vista = new RegistroVista();
        mainWindow.agregarVista("REGISTRO", vista);

        configurarEventos(mainWindow);
    }

    private void configurarEventos(PlataformaStreamingVista mainWindow) {
        vista.getBtnRegistrar().addActionListener(e -> {
    		String nombre = vista.getCampoNombre().getText();
            String apellido = vista.getCampoApellido().getText();
            String dni = vista.getCampoDNI().getText();
            String nombreUsuario = vista.getCampoNombreUsuario().getText();
            String email = vista.getCampoEmail().getText();
            String contrasenia = new String(vista.getCampoContrasenia().getPassword());
    		
            // Validar que no haya campos vacios
    		if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || nombreUsuario.isEmpty() || email.isEmpty() || contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(mainWindow, "Todos los campos son obligatorios");
                return;
            }

            // Validar que no haya errores visibles
            if (!vista.getErrorNombre().getText().isEmpty() ||
                !vista.getErrorApellido().getText().isEmpty() ||
                !vista.getErrorDNI().getText().isEmpty() ||
                !vista.getErrorContrasenia().getText().isEmpty()
            ) {
                JOptionPane.showMessageDialog(mainWindow, "Corrija los errores antes de continuar");
                return;
            }
            
            if(usuarioDAO.buscarPorEmail(email) != null) {
            	JOptionPane.showMessageDialog(mainWindow, "El email ya fue registrado");
            }

            // Guardar en BD
            datosDAO.insertar(nombre, apellido, Long.parseLong(dni));
            DatosPersonales nuevo = datosDAO.buscarPorDNI(Long.parseLong(dni));
            usuarioDAO.insertar(nombre, email, contrasenia, nuevo.getId());

            JOptionPane.showMessageDialog(mainWindow, "Usuario registrado correctamente");

            vista.limpiarCampos();
            mainWindow.mostrar("LOGIN");
        });
        
        vista.getBtnVolver().addActionListener(e -> {
        	mainWindow.mostrar("LOGIN");
        });
        
        vista.getBtnVolver().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	vista.getBtnVolver().setForeground(new Color(60, 0, 200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	vista.getBtnVolver().setForeground(Color.BLUE);
            }
        });
    }

}
