package vista;

import javax.swing.*;
import java.awt.*;

import vista.formulario.FormularioRegistro;

public class RegistroVista extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel norte;
	private FormularioRegistro centro;
	private JPanel sur;

	private JLabel titulo;
	private JLabel labelVolver;
    private JButton btnVolver;

    /*
	public JLabel getTitulo() {
		return titulo;
	}*/
	/*
	public JLabel getLabelNombre() {
		return centro.getLabelNombre();
	}


	public JLabel getLabelApellido() {
		return centro.getLabelApellido();
	}


	public JLabel getLabelDNI() {
		return centro.getLabelDNI();
	}


	public JLabel getLabelNombreUsuario() {
		return centro.getLabelNombreUsuario();
	}


	public JLabel getLabelEmail() {
		return centro.getLabelEmail();
	}


	public JLabel getLabelContrasenia() {
		return centro.getLabelContrasenia();
	}
	*/
	public JTextField getCampoNombre() {
		return centro.getCampoNombre();
	}


	public JTextField getCampoApellido() {
		return centro.getCampoApellido();
	}


	public JTextField getCampoDNI() {
		return centro.getCampoDNI();
	}


	public JTextField getCampoNombreUsuario() {
		return centro.getCampoNombreUsuario();
	}


	public JTextField getCampoEmail() {
		return centro.getCampoEmail();
	}


	public JPasswordField getCampoContrasenia() {
		return centro.getCampoContrasenia();
	}


	public JLabel getErrorNombre() {
		return centro.getErrorNombre();
	}


	public JLabel getErrorApellido() {
		return centro.getErrorApellido();
	}


	public JLabel getErrorDNI() {
		return centro.getErrorDNI();
	}


	public JLabel getErrorNombreUsuario() {
		return centro.getErrorNombreUsuario();
	}


	public JLabel getErrorEmail() {
		return centro.getErrorEmail();
	}


	public JLabel getErrorContrasenia() {
		return centro.getErrorContrasenia();
	}


	public JButton getBtnRegistrar() {
		return centro.getBtnRegistrar();
	}
	
	public JLabel getLabelVolver() {
		return labelVolver;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
	
	public void limpiarCampos() {
		centro.limpiarCampos();
	}
	
	public RegistroVista() {
    	setLayout(new BorderLayout());
    	
    	norte = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    	centro = new FormularioRegistro();
    	sur = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

    	titulo = new JLabel("Formulario de Registro");
    	titulo.setFont(new Font("Roboto", Font.BOLD, 26));
    	titulo.setForeground(new Color(30, 30, 30));
    	
    	labelVolver = new JLabel("¿Ya te habías registrado?");
    	
    	btnVolver = new JButton("Volver");
    	btnVolver.setBorderPainted(false);
    	btnVolver.setOpaque(false);
    	btnVolver.setContentAreaFilled(false);
    	btnVolver.setForeground(Color.BLUE);
    	btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	btnVolver.setFocusPainted(false);

    	norte.add(titulo);
    	sur.add(labelVolver);
    	sur.add(btnVolver);

    	add(norte, BorderLayout.NORTH);
    	add(centro, BorderLayout.CENTER);
    	add(sur, BorderLayout.SOUTH);
    }

}
