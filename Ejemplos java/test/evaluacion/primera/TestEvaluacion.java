package evaluacion.primera;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestEvaluacion {

	@Test
	public void testInsertarRegion() throws SQLException {
		RegionDAO.insertarRegion(6, "prueba");
		Connection con = Conexion.obtenerConexion();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("Select * from HR.region where HR.regions.region_id = 6");
		RegionDTO r = null;
		while (rs.next()) {
			r = new RegionDTO(rs.getInt(1), rs.getString(2));
		}
		Conexion.liberarRecursos(con, stm, rs);
		assertEquals("prueba", r.getRegion_name());
	}

	@Test
	public void testLeerRegion() throws SQLException {
		assertEquals("prueba", RegionDAO.leerRegion(6).getRegion_name());
	}

	@Test
	public void testRecuperarRegiones() {
		fail("Not yet implemented");
	}

}
