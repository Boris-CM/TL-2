package comparador;

import java.util.Comparator;
import modelo.Usuario;

public class CompararPorEmail implements Comparator<Usuario>{

	public int compare(Usuario p1, Usuario p2) {
		if (!(p1.getEmail().equals(p2.getEmail())))
			return p1.getEmail().compareTo(p2.getEmail());
		else
			return 0;
	}
	
}
