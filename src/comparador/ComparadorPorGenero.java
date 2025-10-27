package comparador;

import java.util.Comparator;
import modelo.Contenido;

public class ComparadorPorGenero implements Comparator<Contenido>{

	public int compare(Contenido c1, Contenido c2) {
		return c1.getGenero().compareTo(c2.getGenero());
	}
	
}
