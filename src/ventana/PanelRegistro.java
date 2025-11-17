package ventana;
import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private JTextField campoNombre;
	private JTextField campoApellido;
	private JTextField campoDNI;
    private JTextField campoNombreUsuario;
    private JTextField campoEmail;
    private JPasswordField campoContrasenia;
    private JButton btnRegistrar;
    private JButton btnVolver;

    public PanelRegistro(Main mainWindow) {

        inicializarComponentes();
        configurarEventos(mainWindow);
    }

    private void inicializarComponentes() {
    	campoNombre = new JTextField(15);
    	campoApellido = new JTextField(15);
    	campoDNI = new JTextField(15);
    	campoNombreUsuario = new JTextField(15);
    	campoEmail = new JTextField(15);
        campoContrasenia = new JPasswordField(15);

        btnRegistrar = new JButton("Crear cuenta");
        btnVolver = new JButton("Volver");
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); //Configuración
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0;
        add(new JLabel("Nombre:"), c);
        c.gridx = 1; c.gridy = 0;
        add(campoNombre, c);

        c.gridx = 0; c.gridy = 1;
        add(new JLabel("Apellido:"), c);
        c.gridx = 1; c.gridy = 1;
        add(campoApellido, c);
        
        c.gridx = 0; c.gridy = 2;
        add(new JLabel("DNI:"), c);
        c.gridx = 1; c.gridy = 2;
        add(campoDNI, c);
        
        c.gridx = 0; c.gridy = 3;
        add(new JLabel("Nombre de Usuario:"), c);
        c.gridx = 1; c.gridy = 3;
        add(campoNombreUsuario, c);
        
        c.gridx = 0; c.gridy = 4;
        add(new JLabel("Email:"), c);
        c.gridx = 1; c.gridy = 4;
        add(campoEmail, c);
        
        c.gridx = 0; c.gridy = 5;
        add(new JLabel("Contraseña:"), c);
        c.gridx = 1; c.gridy = 5;
        add(campoContrasenia, c);

        c.gridx = 0; c.gridy = 6;
        add(btnRegistrar, c);
        c.gridx = 1; c.gridy = 6;
        add(btnVolver, c);
    }

    private void configurarEventos(Main mainWindow) {
        btnRegistrar.addActionListener(e -> {
        	String nombre = campoNombre.getText();
        	String apellido = campoApellido.getText();
        	String dni = campoDNI.getText();
            String nombreUsuario = campoNombreUsuario.getText();
            String email = campoEmail.getText();
            String pass = new String(campoContrasenia.getPassword());

            if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || nombreUsuario.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
                return;
            }

            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");
            limpiarCampos();
            mainWindow.mostrarLogin();
        });

        btnVolver.addActionListener(e -> {
        	mainWindow.mostrarLogin();
        });
    }
    
    public void limpiarCampos() {
    	campoNombre.setText("");
    	campoApellido.setText("");
    	campoDNI.setText("");
    	campoNombreUsuario.setText("");
    	campoEmail.setText("");
    	campoContrasenia.setText("");
    }
}
