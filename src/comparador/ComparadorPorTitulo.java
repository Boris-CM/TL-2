package comparador;

import java.util.Comparator;
import modelo.Contenido;

public class ComparadorPorTitulo implements Comparator<Contenido>{

	public int compare(Contenido c1, Contenido c2) {
		if (!(c1.getTitulo()).equals(c2.getTitulo()))
			return c1.getTitulo().compareTo(c2.getTitulo());
		else
			return 0;
	}
	
}

