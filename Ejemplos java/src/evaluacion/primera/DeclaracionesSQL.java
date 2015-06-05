package evaluacion.primera;

public class DeclaracionesSQL {
	
	public static final String insertaRegion = "INSERT INTO HR.regions (region_id,region_name) values (?,?)";
	public static final String recuperaRegiones = "SELECT * FROM HR.regions";
	public static final String recuperaRegion = "SELECT * FROM HR.regions WHERE HR.regions.region_id = ?";
}
