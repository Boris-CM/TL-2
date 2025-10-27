package dao;

import java.sql.Connection;
import java.util.List;
import modelo.DatosPersonales;

public interface DatosPersonalesDAO {

    public void insertar(Connection cx, String nombre, String apellido, int dni);

    public List<DatosPersonales> listarTodos(Connection cx);
    
    public DatosPersonales buscarPorDNI(Connection cx, int dni);
}
