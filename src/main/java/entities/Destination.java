package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@NamedQueries({@NamedQuery(name="getDestinationById",
							query="select d from Destination d where d.id=:id"),
				@NamedQuery(name="getDestinationBRegion",
							query="select d from Destination d where d.region=:region "),
				@NamedQuery(name="getAll",query="from Destination")
//				@NamedQuery(name="showDates",
//							query="select d from Destination d where d."}
})

@Entity
@Table(name="destinations")
public class Destination {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_destination")
	private long id;
	
	@Column(name="description")
	private String description;
	@Column(name="region")
	private String region;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ke_destination")
	
	private List<DatesVoyage> listeDV;
	
	public Destination(){}
	
	
	public Destination(String description, String region, List<DatesVoyage> listeDV) {
		
		
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
		return "Destination [id=" + id +", description=" + description
				+ ", region=" + region + ", listeDV=" + listeDV + "]";
	}

	
	
}
