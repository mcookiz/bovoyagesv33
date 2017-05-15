package entities;

import java.util.Date;

public class DatesVoyage {
	private long id;
	private Date dateDepart;
	private Date dateRetour;
	private long prix;
	
	public DatesVoyage(){}
	
	
	public DatesVoyage(Date dateDepart, Date dateRetour, long prix) {
		
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.prix = prix;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}


	@Override
	public String toString() {
		return "DatesVoyage [id=" + id + ", dateDepart=" + dateDepart + ", dateRetour=" + dateRetour + ", prix=" + prix
				+ "]";
	}
	
	

}
