package jsf;

import java.io.Serializable;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.enterprise.context.Conversation;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import entities.DatesVoyage;
import entities.Destination;
import service.Service;

@Named("bean")
@ViewScoped
public class Bean implements Serializable {
	@Inject
	Service service;

	@Inject
	Conversation conv;
	private Long id;
	private String region;
	private String description;
	private List<DatesVoyage> ldv = new ArrayList<>();
	List<Destination> ld = new ArrayList<>();

	@PostConstruct
	public void init() {
		ld = service.getAll();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bean() {
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DatesVoyage> getLdv() {
		return ldv;
	}

	public void setLdv(List<DatesVoyage> ldv) {
		this.ldv = ldv;
	}

	public String save() {
		Destination d = new Destination(description, region, ldv);
		service.save(d);
		endConversation();
		return "index";

	}

	public String startSave(Destination d) {
		startConversation();

		return "addDestination";
	}

	public String update() {
		Destination d = new Destination(description, region, ldv);
		d.setId(id);
		service.update(d);
		endConversation();
		return "index";

	}

	public String startUpdate(long id) {
		startConversation();
		Destination d = service.getDestinationById(id);
		this.setId(d.getId());
		this.setRegion(d.getRegion());
		this.setDescription(d.getDescription());
		this.setLdv(d.getListeDV());
		return "updateDestination";

	}

//	 public String SearchByRegion(String region) {
//	 startConversation();
//	 this.setLd(service.getDestinationByRegion(region));
//	 return "searchByRegion";
//	 }

	public String remove(long id) {
		Destination d = new Destination(description, region, ldv);
		d.setId(id);
		service.remove(id);
		return "index";

	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Destination Edited");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		service.update((Destination) event.getObject());

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	

	public void startConversation() {
		if (conv.isTransient()) {
			conv.begin();
		}
	}

	public void endConversation() {
		if (!conv.isTransient()) {
			conv.end();
		}
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<Destination> getLd() {
		return ld;
	}

	public void setLd(List<Destination> ld) {
		this.ld = ld;
	}

}
