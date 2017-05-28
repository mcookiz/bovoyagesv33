package jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.DatesVoyage;
import entities.Destination;
import service.Service;

@Named("bean")
@ConversationScoped
public class Bean implements Serializable {
	@Inject Service service;
	
	@Inject Conversation conv;
    private Long id;
	private String region;
	private String description;
	private List<Destination>ld = new ArrayList<>();
	private List<DatesVoyage>ldv= new ArrayList<>();

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
		
		return "addDestination";}

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
	
	public String startSearchByRegion(String region) {
		startConversation();
		this.setLd(service.getDestinationByRegion(region));
		return "searchByRegion";	
	}
	
	public String remove(long id) {
		Destination d = new Destination(description, region, ldv);
		d.setId(id);
		service.remove(id);
		return "index";

	}
	
	public void startConversation(){
		if(conv.isTransient()){
			conv.begin();
		}
	}

	public void endConversation(){
		if(!conv.isTransient()){
			conv.end();
		}
	}

	public List<Destination> getLd() {
		return ld;
	}

	public void setLd(List<Destination> ld) {
		this.ld = ld;
	}
}
