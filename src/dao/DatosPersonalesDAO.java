package dao;

import java.util.List;
import modelo.DatosPersonales;

public interface DatosPersonalesDAO {

    public void insertar(String nombre, String apellido, long dni);

    public List<DatosPersonales> listarTodos();
    
    public DatosPersonales buscarPorDNI(long dni);
}
