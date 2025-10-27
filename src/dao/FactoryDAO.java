package dao;

import dao.implJDBC.*;

public class FactoryDAO {
    private final DatosPersonalesDAOjdbc datosDAO = new DatosPersonalesDAOjdbc();
    private final UsuarioDAOjdbc usuarioDAO = new UsuarioDAOjdbc();
    private final PeliculaDAOjdbc peliculaDAO = new PeliculaDAOjdbc();
    private final ReseniaDAOjdbc reseniaDAO = new ReseniaDAOjdbc();
    
	public DatosPersonalesDAOjdbc getDatosDAO() {
		return datosDAO;
	}
	public UsuarioDAOjdbc getUsuarioDAO() {
		return usuarioDAO;
	}
	public PeliculaDAOjdbc getPeliculaDAO() {
		return peliculaDAO;
	}
	public ReseniaDAOjdbc getReseniaDAO() {
		return reseniaDAO;
	}

    
}
