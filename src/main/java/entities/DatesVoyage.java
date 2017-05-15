package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dates_voyages")
public class DatesVoyage {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_date_voyage")
	private long id;
	@Column(name="date_depart")
	private Date dateDepart;
	@Column(name="date_retour")
	private Date dateRetour;
	@Column(name="prixHT")
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
