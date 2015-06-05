package evaluacion.primera;

import java.sql.SQLException;
import java.util.List;

public class MainRegionDAO {

	public static void main(String[] args) {
		try {
			List<RegionDTO> lrs = RegionDAO.recuperarRegiones();
			System.out.println(lrs);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al recuperar las regiones");
		}

		try {
			RegionDAO.insertarRegion(5,"Oceania"); 
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al insertar la región");
		}
		
		try {
			List<RegionDTO> lrs = RegionDAO.recuperarRegiones();
			System.out.println(lrs);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al recuperar las regiones");
		}
		
		try {
			System.out.println(RegionDAO.leerRegion(5));
		} catch (SQLException e) {
			System.out.println("Error al recuperar región");
		}
	}

}
