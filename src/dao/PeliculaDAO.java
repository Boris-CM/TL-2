package dao;

import modelo.Pelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    public void insertar(Pelicula p) {
        String sql = "INSERT INTO PELICULA (GENERO, TITULO, RESUMEN, DIRECTOR, DURACION) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getGenero().name());
            ps.setString(2, p.getTitulo());
            ps.setString(3, p.getResumen());
            ps.setString(4, p.getDirector());
            ps.setDouble(5, p.getDuracion());
            ps.executeUpdate();
            System.out.println("✅ Película guardada correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar película: " + e.getMessage());
        }
    }

    public List<Pelicula> listarTodas() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM PELICULA";
        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Pelicula p = new Pelicula(
                        rs.getInt("ID"),
                        rs.getString("TITULO"),
                        rs.getString("DIRECTOR"),
                        rs.getString("RESUMEN"),
                        rs.getDouble("DURACION"),
                        rs.getString("GENERO")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar películas: " + e.getMessage());
        }
        return lista;
    }
}
