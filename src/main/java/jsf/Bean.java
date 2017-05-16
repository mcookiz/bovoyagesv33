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

	private String region;
	private String description;

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

	public String update(long id) {
		Destination d = new Destination(description, region);
		d.setId(id);
		service.update(id);
		return "index";

	}
	public String startUpdate(long id) {
		
		Destination d = new Destination(description, region);
		d.setId(id);
		
		
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
