package ventana;
import javax.swing.*;
import java.awt.*;

public class PanelLogin extends JPanel {
	
	private static final long serialVersionUID = 1L;

    private JTextField campoEmail;
    private JPasswordField campoContrasenia;
    private JButton btnIngresar;
    private JButton btnRegistrar;

    public PanelLogin(Main mainWindow) {

        inicializarComponentes();
        configurarEventos(mainWindow);
    }

    private void inicializarComponentes() {
    	setLayout(new GridBagLayout());
    	
    	campoEmail = new JTextField(15);
        campoContrasenia = new JPasswordField(15);

        btnIngresar = new JButton("Ingresar");
        btnRegistrar = new JButton("Registrarse");

        
        GridBagConstraints c = new GridBagConstraints(); //Configuración
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0;
        add(new JLabel("Email:"), c);

        c.gridx = 1; c.gridy = 0;
        add(campoEmail, c);

        c.gridx = 0; c.gridy = 1;
        add(new JLabel("Contraseña:"), c);

        c.gridx = 1; c.gridy = 1;
        add(campoContrasenia, c);

        c.gridx = 0; c.gridy = 2;
        add(btnIngresar, c);
        c.gridx = 1; c.gridy = 2;
        add(btnRegistrar, c);
    }

    private void configurarEventos(Main mainWindow) {
        btnIngresar.addActionListener(e -> {
            String email = campoEmail.getText();
            String contrasenia = new String(campoContrasenia.getPassword());

            if (email.isEmpty() || contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar Email y Contraseña");
                return;
            }

            JOptionPane.showMessageDialog(this, "Intentando ingresar...");
            limpiarCampos();
        });

        btnRegistrar.addActionListener(e -> {
        	mainWindow.mostrarRegistro();
        });
    }
    
    public void limpiarCampos() {
    	campoEmail.setText("");
    	campoContrasenia.setText("");
    }

}
    