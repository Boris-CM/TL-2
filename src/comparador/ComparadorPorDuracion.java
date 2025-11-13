package comparador;

import java.util.Comparator;
import modelo.Audiovisual;

public class ComparadorPorDuracion implements Comparator<Audiovisual>{

	public int compare(Audiovisual c1, Audiovisual c2) {
		if (c1.getDuracion() == c1.getDuracion())
			return 0;
		else if (c1.getDuracion() > c1.getDuracion())
			return 1;
		else
			return -1;
	}
	
}
