package dao;

import java.util.List;
import modelo.Usuario;

public interface UsuarioDAO {

    public void insertar(String nombreUsuario, String email, String contrasenia, int idDP);

    public List<Usuario> listarTodos();

    public Usuario buscarPorCredenciales(String usuario, String contrasenia);
    
}
