package jsf;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

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

	public String save() {
		Destination d = new Destination(description, region);
		service.save(d);
		return "index";

	}

	public String update() {
		Destination d = new Destination(description, region);
		d.setId(id);
		service.update(d);
		return "index";

	}
	public String startUpdate(long id) {
		startConversation();
		Destination d = service.getDestinationById(id);
		this.setId(d.getId());
		this.setRegion(d.getRegion());
		this.setDescription(d.getDescription());
		return "update";
		
		
	}
	public String remove(long id) {
		Destination d = new Destination(description, region);
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
}
