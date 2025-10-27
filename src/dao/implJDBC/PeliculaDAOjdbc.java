package dao.implJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PeliculaDAO;
import enumerativo.Genero;
import enumerativo.TipoContenido;
import modelo.Audiovisual;

public class PeliculaDAOjdbc implements PeliculaDAO{
	public void insertar(Connection cx, String titulo, String director, String resumen, double duracion, String genero) {
        String sql = "INSERT INTO PELICULA (GENERO, TITULO, RESUMEN, DIRECTOR, DURACION) VALUES (?, ?, ?, ?, ?)";
        try {
        	PreparedStatement ps = cx.prepareStatement(sql);

            ps.setString(1, genero);
            ps.setString(2, titulo);
            ps.setString(3, resumen);
            ps.setString(4, director);
            ps.setDouble(5, duracion);
            ps.executeUpdate();
            System.out.println("✅ Película guardada correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar película: " + e.getMessage());
        }
    }

    public List<Audiovisual> listarTodas(Connection cx) {
        List<Audiovisual> lista = new ArrayList<Audiovisual>();
        String sql = "SELECT * FROM PELICULA";
        try {
        	Statement st = cx.createStatement();
            ResultSet rs = st.executeQuery(sql);
        	
            while (rs.next()) {
            	Genero genero = Genero.valueOf(rs.getString("GENERO").toUpperCase());
            	Audiovisual p = new Audiovisual(
                        rs.getInt("ID"),
                        rs.getString("TITULO"),
                        rs.getString("RESUMEN"),
                        rs.getString("DIRECTOR"),
                        genero,
                        rs.getDouble("DURACION"),
                        TipoContenido.PELICULA
                );
                lista.add(p);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("❌ Error al listar películas: " + e.getMessage());
        }
        return lista;
    }
}
