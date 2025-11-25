package dao;

import java.util.List;
import modelo.Audiovisual;

public interface PeliculaDAO {

    public void insertar(String titulo, String director, String resumen, double duracion, String genero);

    public List<Audiovisual> listarTodas();
    
}