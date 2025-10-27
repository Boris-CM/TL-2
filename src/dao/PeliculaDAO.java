package dao;

import java.sql.Connection;
import java.util.List;
import modelo.Audiovisual;

public interface PeliculaDAO {

    public void insertar(Connection cx, String titulo, String director, String resumen, double duracion, String genero);

    public List<Audiovisual> listarTodas(Connection cx);
    
}