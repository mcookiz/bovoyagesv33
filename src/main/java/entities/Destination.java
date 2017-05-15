package entities;

import java.util.List;

public class Destination {
	private long id;
	private String continent;
	private String pays;
	private String description;
	private String region;
	private List<DatesVoyage> listeDV;
	
	public Destination(){}
	
	
	public Destination(String continent, String pays, String description, String region, List<DatesVoyage> listeDV) {
		
		this.continent = continent;
		this.pays = pays;
		this.description = description;
		this.region = region;
		this.listeDV = listeDV;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	public List<DatesVoyage> getListeDV() {
		return listeDV;
	}
	public void setListeDV(List<DatesVoyage> listeDV) {
		this.listeDV = listeDV;
	}


	@Override
	public String toString() {
		return "Destination [id=" + id + ", continent=" + continent + ", pays=" + pays + ", description=" + description
				+ ", region=" + region + ", listeDV=" + listeDV + "]";
	}

	
	
}
