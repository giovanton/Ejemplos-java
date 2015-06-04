package evaluacion.primera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class RegionDAO {

	private static Logger log = Logger.getLogger("dblog");
	
	private static RegionDTO fabricarRegion(ResultSet rs) throws SQLException {
		/* construye el objeto region*/
		
		RegionDTO region = null;
		int id_reg = rs.getInt(1);
		String name_reg = rs.getString(2);
		
		region = new RegionDTO(id_reg, name_reg);
		return region;
		
	}
	
	public void insertarRegion(String region_nueva) throws SQLException {
		/* Método para insertar una región en BBDD*/
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
		con = Conexion.obtenerConexion();                   
		con.setAutoCommit(false);
		pst = con.prepareStatement(DeclaracionesSQL.insertaRegion);
		pst.setString(1, region_nueva);
		con.commit();
		} catch (SQLException e ) {
			e.printStackTrace();
			log.error("Error al insertar registro");
			con.rollback();
			throw e;
			
		} finally {
			Conexion.liberarRecursos(con, pst);
		}
	}
	
	public RegionDTO leerRegion() {
		//TODO leer una region de la tabla por su id
		return null;
	}
	
	public List<RegionDTO> recuperarRegiones() throws SQLException{
		/* Recupera todas las regiones de la tabla*/
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		List<RegionDTO> lr= null;
		
		try {
		con = Conexion.obtenerConexion();
		stm = con.createStatement();
		rs = stm.executeQuery(DeclaracionesSQL.recuperaRegiones);
		lr = new ArrayList<RegionDTO>();
		while(rs.next()) {
			RegionDTO region = new RegionDTO(rs.getInt(1), rs.getString(2));
			lr.add(region);
			
		}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Error al recuperar regiones");
			lr = null;
			throw e;
		}
		return lr;
	}
	
}
