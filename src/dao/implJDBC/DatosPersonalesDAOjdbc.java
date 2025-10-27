package dao.implJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DatosPersonalesDAO;
import modelo.DatosPersonales;

public class DatosPersonalesDAOjdbc implements DatosPersonalesDAO{
	public void insertar(Connection cx, String nombre, String apellido, int dni) {
        String sql = "INSERT INTO DATOS_PERSONALES (NOMBRES, APELLIDO, DNI) VALUES (?, ?, ?)";
        try {
        	PreparedStatement ps = cx.prepareStatement(sql);
        	
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, dni);
            ps.executeUpdate();
            System.out.println("✅ Datos personales guardados correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar datos personales: " + e.getMessage());
        }
    }

    public List<DatosPersonales> listarTodos(Connection cx) {
        List<DatosPersonales> lista = new ArrayList<DatosPersonales>();
        String sql = "SELECT * FROM DATOS_PERSONALES";
        try {
        	Statement st = cx.createStatement();
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
}
