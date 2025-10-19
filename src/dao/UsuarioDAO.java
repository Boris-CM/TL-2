package dao;

import modelo.Usuario;
import modelo.DatosPersonales;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void insertar(Usuario u) {
        String sql = "INSERT INTO USUARIO (NOMBRE_USUARIO, EMAIL, CONTRASENIA, ID_DATOS_PERSONALES) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getContrasenia());
            ps.setInt(4, u.getDatos().getId());
            ps.executeUpdate();
            System.out.println("✅ Usuario guardado correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar usuario: " + e.getMessage());
        }
    }

    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = """
            SELECT U.ID, U.NOMBRE_USUARIO, U.EMAIL, U.CONTRASENIA,
                   D.ID AS DP_ID, D.NOMBRES, D.APELLIDO, D.DNI
            FROM USUARIO U
            JOIN DATOS_PERSONALES D ON U.ID_DATOS_PERSONALES = D.ID
            """;
        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                DatosPersonales dp = new DatosPersonales(
                        rs.getInt("DP_ID"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDO"),
                        rs.getInt("DNI")
                );

                Usuario u = new Usuario(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE_USUARIO"),
                        rs.getString("EMAIL"),
                        rs.getString("CONTRASENIA"),
                        dp
                );

                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    public Usuario buscarPorCredenciales(String usuario, String contrasenia) {
        String sql = """
            SELECT U.ID, U.NOMBRE_USUARIO, U.EMAIL, U.CONTRASENIA,
                   D.ID AS DP_ID, D.NOMBRES, D.APELLIDO, D.DNI
            FROM USUARIO U
            JOIN DATOS_PERSONALES D ON U.ID_DATOS_PERSONALES = D.ID
            WHERE U.NOMBRE_USUARIO = ? AND U.CONTRASENIA = ?
        """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DatosPersonales dp = new DatosPersonales(
                        rs.getInt("DP_ID"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDO"),
                        rs.getInt("DNI")
                );
                return new Usuario(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE_USUARIO"),
                        rs.getString("EMAIL"),
                        rs.getString("CONTRASENIA"),
                        dp
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar usuario: " + e.getMessage());
        }
        return null;
    }
}
