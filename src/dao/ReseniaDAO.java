package dao;

import java.util.List;
import modelo.Resenia;

public interface ReseniaDAO {

    public void insertar(int calificaion, String comentario, int aprobado, String fechaHora, int idU, int idP);

    public List<Resenia> listarNoAprobadas();

    public void aprobar(int idResenia);
    
}
