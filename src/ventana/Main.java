package ventana;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private Panel panelDer;
	private JPanel panelIzq;
	private CardLayout cardLayout;
	//private final double tamanioVentana= 40;
	
	public Main() {
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		setLayout(new GridBagLayout());
		
		
		panelDer = new Panel();
		panelIzq = new JPanel();
		// Configuramos el CardLayout
		cardLayout = new CardLayout();
		panelIzq.setLayout(cardLayout);

        // Agregamos las ventanas al contenedor
		panelIzq.add(new PanelLogin(this), "LOGIN");
		panelIzq.add(new PanelRegistro(this), "REGISTRO");
		
        
        GridBagConstraints c = new GridBagConstraints();
		
		// ===== Panel Izquierdo (30%) =====
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.8;     // 80% del espacio horizontal
        c.weighty = 1.0;     // ocupa toda la altura
        c.fill = GridBagConstraints.BOTH;
        add(panelDer, c);

        // ===== Panel Derecho (70%) =====
        c.gridx = 1;
        c.weightx = 0.2;     // 20% del espacio horizontal
        add(panelIzq, c);

		
		// Configuración final de la ventana
		setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setVisible(true);
	}
	
	public void mostrarLogin() {
        cardLayout.show(panelIzq, "LOGIN");
    }

    public void mostrarRegistro() {
        cardLayout.show(panelIzq, "REGISTRO");
    }
	
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

}
