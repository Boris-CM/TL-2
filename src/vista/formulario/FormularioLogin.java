package vista.formulario;

import java.awt.*;
import javax.swing.*;

public class FormularioLogin extends JPanel {

	private static final long serialVersionUID = 1L;

    private JTextField campoEmail;
    private JPasswordField campoContrasenia;
    private JButton btnIngresar;

    public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JPasswordField getCampoContrasenia() {
		return campoContrasenia;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public FormularioLogin() {
		setLayout(new GridBagLayout());
    	
    	campoEmail = new JTextField(15);
        campoContrasenia = new JPasswordField(15);

        btnIngresar = new JButton("Ingresar");

        
        GridBagConstraints c = new GridBagConstraints();
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

        c.gridx = 1; c.gridy = 2;
        add(btnIngresar, c);
    }
    
    public void limpiarCampos() {
    	campoEmail.setText("");
    	campoContrasenia.setText("");
    }
    
}
