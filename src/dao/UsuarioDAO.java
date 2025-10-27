package dao;

import java.sql.Connection;
import java.util.List;
import modelo.Usuario;

public interface UsuarioDAO {

    public void insertar(Connection cx, String nombreUsuario, String email, String contrasenia, int idDP);

    public List<Usuario> listarTodos(Connection cx);

    public Usuario buscarPorCredenciales(Connection cx, String usuario, String contrasenia);
    
}
