package vista;

import java.awt.*;
import javax.swing.*;


public class PlataformaStreamingVista extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private CardLayout cardLayout;
    private JPanel panelDerecha;
    private JPanel panelIzquierda;
	private GridBagLayout gridBagLayout;

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JPanel getPanelDerecha() {
		return panelDerecha;
	}

	public JPanel getPanelIzquierda() {
		return panelIzquierda;
	}

	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	public PlataformaStreamingVista() {
    	setSize(1000, 750);
    	gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        panelDerecha = new PanelDerechaVista();

        panelIzquierda = new JPanel(cardLayout);
        panelIzquierda.add(new JLabel("Panel Izquierdo"));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.weightx = 0.6;
        c.weighty = 1;
        add(panelDerecha, c);

        c.gridx = 1;
        c.weightx = 0.4;
        add(panelIzquierda, c);
    }

    public void agregarVista(String nombre, JPanel panel) {
    	panelIzquierda.add(panel, nombre);
    }

    public void mostrar(String nombre) {
    	cardLayout.show(panelIzquierda, nombre);
    }
}
