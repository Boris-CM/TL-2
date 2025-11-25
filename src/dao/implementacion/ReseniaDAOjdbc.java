package dao.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBD;
import dao.ReseniaDAO;
import modelo.Resenia;

public class ReseniaDAOjdbc implements ReseniaDAO{
	public void insertar(int calificaion, String comentario, int aprobado, String fechaHora, int idU, int idP) {
        String sql = "INSERT INTO RESENIA (CALIFICACION, COMENTARIO, APROBADO, FECHA_HORA, ID_USUARIO, ID_PELICULA) VALUES (?, ?, ?, ?, ?, ?)";
        try {
        	PreparedStatement ps = ConexionBD.getInstancia().getConexion().prepareStatement(sql);

            ps.setInt(1, calificaion);
            ps.setString(2, comentario);
            ps.setInt(3, aprobado);
            ps.setString(4, fechaHora);
            ps.setInt(5, idU);
            ps.setInt(6, idP);
            ps.executeUpdate();
            System.out.println("✅ Reseña guardada correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar reseña: " + e.getMessage());
        }
    }

    public List<Resenia> listarNoAprobadas() {
        List<Resenia> lista = new ArrayList<Resenia>();
        String sql = "SELECT * FROM RESENIA WHERE APROBADO = 0";
        try {
        	Statement st = ConexionBD.getInstancia().getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

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
            st.close();

        } catch (SQLException e) {
            System.out.println("❌ Error al listar reseñas: " + e.getMessage());
        }
        return lista;
    }

    public void aprobar(int idResenia) {
        String sql = "UPDATE RESENIA SET APROBADO = 1 WHERE ID = ?";
        try {
            PreparedStatement ps = ConexionBD.getInstancia().getConexion().prepareStatement(sql);
        
            ps.setInt(1, idResenia);
            int filas = ps.executeUpdate();
            if (filas > 0) System.out.println("✅ Reseña aprobada.");
            else System.out.println("⚠️ No se encontró la reseña.");
        } catch (SQLException e) {
            System.out.println("❌ Error al aprobar reseña: " + e.getMessage());
        }
    }


}
