package evaluacion.primera;

public class RegionDTO {
	private int region_id;
	private String region_name;
	
	public RegionDTO(int r_id,String r_name) {
		this.region_id = r_id;
		this.region_name = r_name;
	}
	
	public int getRegion_id() {
		return region_id;
	}
	
	public String getRegion_name() {
		return region_name;
	}
	
	@Override
	public String toString() {
		return ("Region : " + this.region_name);
	}
}
