package dao;

import java.sql.Connection;
import java.util.List;
import modelo.Resenia;

public interface ReseniaDAO {

    public void insertar(Connection cx, int calificaion, String comentario, int aprobado, String fechaHora, int idU, int idP);

    public List<Resenia> listarNoAprobadas(Connection cx);

    public void aprobar(Connection cx, int idResenia);
    
}
