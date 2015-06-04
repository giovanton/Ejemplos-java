package evaluacion.primera;

public class DeclaracionesSQL {
	
	public static final String insertaRegion = "INSERT region_name INTO HR.regions values(?)";
	public static final String recuperaRegiones = "SELECT * FROM HR.regions";
	public static final String recuperaRegion = "SELECT name FROM HR.regions WHERE HR.regions.id = ?";
}
