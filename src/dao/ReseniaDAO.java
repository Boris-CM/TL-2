package dao;

import modelo.Resenia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReseniaDAO {

    public void insertar(Resenia r) {
        String sql = "INSERT INTO RESENIA (CALIFICACION, COMENTARIO, FECHA_HORA, ID_USUARIO, ID_PELICULA) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, r.getCalificacion());
            ps.setString(2, r.getComentario());
            ps.setString(3, r.getFechaHora());
            ps.setInt(4, r.getIdUsuario());
            ps.setInt(5, r.getIdPelicula());
            ps.executeUpdate();
            System.out.println("✅ Reseña guardada correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar reseña: " + e.getMessage());
        }
    }

    public List<Resenia> listarNoAprobadas() {
        List<Resenia> lista = new ArrayList<>();
        String sql = "SELECT * FROM RESENIA WHERE APROBADO = 0";
        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Resenia(
                        rs.getInt("ID"),
                        rs.getInt("CALIFICACION"),
                        rs.getString("COMENTARIO"),
                        rs.getString("FECHA_HORA"),
                        rs.getInt("ID_USUARIO"),
                        rs.getInt("ID_PELICULA"),
                        rs.getInt("APROBADO") == 1
                ));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar reseñas: " + e.getMessage());
        }
        return lista;
    }

    public void aprobar(int idResenia) {
        String sql = "UPDATE RESENIA SET APROBADO = 1 WHERE ID = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idResenia);
            int filas = ps.executeUpdate();
            if (filas > 0) System.out.println("✅ Reseña aprobada.");
            else System.out.println("⚠️ No se encontró la reseña.");
        } catch (SQLException e) {
            System.out.println("❌ Error al aprobar reseña: " + e.getMessage());
        }
    }
}
