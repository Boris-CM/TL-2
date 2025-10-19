package dao;

import modelo.DatosPersonales;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatosPersonalesDAO {

    public void insertar(DatosPersonales dp) {
        String sql = "INSERT INTO DATOS_PERSONALES (NOMBRES, APELLIDO, DNI) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dp.getNombres());
            ps.setString(2, dp.getApellido());
            ps.setInt(3, dp.getDni());
            ps.executeUpdate();
            System.out.println("✅ Datos personales guardados correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar datos personales: " + e.getMessage());
        }
    }

    public List<DatosPersonales> listarTodos() {
        List<DatosPersonales> lista = new ArrayList<>();
        String sql = "SELECT * FROM DATOS_PERSONALES";
        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                DatosPersonales dp = new DatosPersonales(
                        rs.getInt("ID"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDO"),
                        rs.getInt("DNI")
                );
                lista.add(dp);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar datos personales: " + e.getMessage());
        }
        return lista;
    }
}
