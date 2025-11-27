package vista;

import javax.swing.*;
import java.awt.*;

import vista.formulario.FormularioLogin;

public class LoginVista extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private JPanel norte;
	private FormularioLogin centro;
	private JPanel sur;

	private JLabel titulo;
	private JLabel label;
    private JButton btnRegistrar;
    
    public JTextField getCampoEmail() {
		return centro.getCampoEmail();
	}

	public JPasswordField getCampoContrasenia() {
		return centro.getCampoContrasenia();
	}

	public JButton getBtnIngresar() {
		return centro.getBtnIngresar();
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JLabel getLabel() {
		return label;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	
	public void limpiarCampos() {
		centro.limpiarCampos();
	}

    public LoginVista() {
    	setLayout(new BorderLayout());
    	
    	norte = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    	centro = new FormularioLogin();
    	sur = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

    	titulo = new JLabel("Inicio de sesion");
    	titulo.setFont(new Font("Roboto", Font.BOLD, 26));
    	titulo.setForeground(new Color(30, 30, 30));
    	
    	label = new JLabel("¿Aun no sos usuario?");
    	
    	btnRegistrar = new JButton("Registrate");
    	btnRegistrar.setBorderPainted(false);
    	btnRegistrar.setOpaque(false);
    	btnRegistrar.setContentAreaFilled(false);
    	btnRegistrar.setForeground(Color.BLUE);
    	btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	btnRegistrar.setFocusPainted(false);

    	norte.add(titulo);
    	sur.add(label);
    	sur.add(btnRegistrar);

    	add(norte, BorderLayout.NORTH);
    	add(centro, BorderLayout.CENTER);
    	add(sur, BorderLayout.SOUTH);
    }
}
    