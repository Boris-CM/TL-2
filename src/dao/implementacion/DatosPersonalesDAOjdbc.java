package dao.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBD;
import dao.DatosPersonalesDAO;
import modelo.DatosPersonales;

public class DatosPersonalesDAOjdbc implements DatosPersonalesDAO{
	
	public void insertar(String nombre, String apellido, long dni) {
        String sql = "INSERT INTO DATOS_PERSONALES (NOMBRES, APELLIDO, DNI) VALUES (?, ?, ?)";
        try {
        	PreparedStatement ps = ConexionBD.getInstancia().getConexion().prepareStatement(sql);
        	
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setLong(3, dni);
            ps.executeUpdate();
            System.out.println("✅ Datos personales guardados correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar datos personales: " + e.getMessage());
        }
    }

    public List<DatosPersonales> listarTodos() {
        List<DatosPersonales> lista = new ArrayList<DatosPersonales>();
        String sql = "SELECT * FROM DATOS_PERSONALES";
        try {
        	Statement st = ConexionBD.getInstancia().getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                DatosPersonales dp = new DatosPersonales(
                        rs.getInt("ID"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDO"),
                        rs.getInt("DNI")
                );
                lista.add(dp);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("❌ Error al listar datos personales: " + e.getMessage());
        }
        return lista;
    }
    
    public DatosPersonales buscarPorDNI(long dni) {
        String sql = """
            SELECT *
            FROM DATOS_PERSONALES
            WHERE DNI = ?
        """;
        try {
        	PreparedStatement ps = ConexionBD.getInstancia().getConexion().prepareStatement(sql);
        	
            ps.setLong(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new DatosPersonales(
                        rs.getInt("ID"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDO"),
                        rs.getInt("DNI")
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar usuario: " + e.getMessage());
        }
        return null;
    }
}
