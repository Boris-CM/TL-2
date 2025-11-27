package vista;

import javax.swing.*;
import java.awt.*;

public class PanelDerechaVista extends JPanel  {
	
	private static final long serialVersionUID = 1L;

	public PanelDerechaVista() {
		setOpaque(true);
	}
	
	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		GradientPaint gra = new GradientPaint(0, 0, new Color(57, 50, 219), 0, getHeight(), new Color(12, 8, 92));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}

}
