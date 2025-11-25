package ventana;
import javax.swing.*;

import dao.implementacion.UsuarioDAOjdbc;

import java.awt.*;
import java.awt.event.*;

public class PanelLogin extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private JPanel norte;
	private JPanel centro;
	private JPanel sur;

	private JLabel titulo;
	private JLabel label;
    private JButton btnRegistrar;

    public PanelLogin(Main mainWindow, UsuarioDAOjdbc usuarioDAO) {
        inicializarComponentes(mainWindow, usuarioDAO);
        configurarEventos(mainWindow);
    }

    private void inicializarComponentes(Main mainWindow, UsuarioDAOjdbc usuarioDAO) {
    	setLayout(new BorderLayout());
    	
    	norte = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    	centro = new FormularioLogin(mainWindow, usuarioDAO);
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

    private void configurarEventos(Main mainWindow) {

    	btnRegistrar.addActionListener(e -> mainWindow.mostrarRegistro());
        
    	btnRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnRegistrar.setForeground(new Color(60, 0, 200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnRegistrar.setForeground(Color.BLUE);
            }
        });
        
    }

}
    