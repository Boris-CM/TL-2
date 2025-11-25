package ventana;
import javax.swing.*;

import dao.implementacion.DatosPersonalesDAOjdbc;
import dao.implementacion.UsuarioDAOjdbc;

import java.awt.*;
import java.awt.event.*;

public class PanelRegistro extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel norte;
	private JPanel centro;
	private JPanel sur;

	private JLabel titulo;
	private JLabel label;
    private JButton btnVolver;

    public PanelRegistro(Main mainWindow, DatosPersonalesDAOjdbc datosPersonalesDAO, UsuarioDAOjdbc usuarioDAO) {
    	
        
        inicializarComponentes(mainWindow, datosPersonalesDAO, usuarioDAO);
        configurarEventos(mainWindow);
    }

    private void inicializarComponentes(Main mainWindow, DatosPersonalesDAOjdbc datosPersonalesDAO, UsuarioDAOjdbc usuarioDAO) {
    	setLayout(new BorderLayout());
    	
    	norte = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    	centro = new FormularioRegistro(mainWindow, datosPersonalesDAO, usuarioDAO);
    	sur = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

    	titulo = new JLabel("Formulario de Registro");
    	titulo.setFont(new Font("Roboto", Font.BOLD, 26));
    	titulo.setForeground(new Color(30, 30, 30));
    	
    	label = new JLabel("¿Ya te habías registrado?");
    	
    	btnVolver = new JButton("Volver");
    	btnVolver.setBorderPainted(false);
    	btnVolver.setOpaque(false);
    	btnVolver.setContentAreaFilled(false);
    	btnVolver.setForeground(Color.BLUE);
    	btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	btnVolver.setFocusPainted(false);

    	norte.add(titulo);
    	sur.add(label);
    	sur.add(btnVolver);

    	add(norte, BorderLayout.NORTH);
    	add(centro, BorderLayout.CENTER);
    	add(sur, BorderLayout.SOUTH);
    }

    private void configurarEventos(Main mainWindow) {

        btnVolver.addActionListener(e -> mainWindow.mostrarLogin());
        
        btnVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnVolver.setForeground(new Color(60, 0, 200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnVolver.setForeground(Color.BLUE);
            }
        });
        
    }

}
