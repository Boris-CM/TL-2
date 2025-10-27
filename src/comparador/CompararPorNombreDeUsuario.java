package comparador;

import java.util.Comparator;
import modelo.Usuario;

public class CompararPorNombreDeUsuario implements Comparator<Usuario>{

	public int compare(Usuario p1, Usuario p2) {
		if (!(p1.getNombreUsuario().equals(p2.getNombreUsuario())))
			return p1.getNombreUsuario().compareTo(p2.getNombreUsuario());
		else
			return 0;
	}

}
