package service;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.IBoVoyagesDAO;
import entities.Destination;
@Named("service")
@ApplicationScoped
public class Service {
	
	
	
	public Service() {
		
	}

	private static final Logger LOG =Logger.getLogger("service");
	@Inject private IBoVoyagesDAO dao;
	
	public Destination getDestinationById(long id) {
		
		Destination d =dao.getDestinationById(id);
		return d;
	}
	
	public List<Destination> getDestinationByRegion(String region) {
		
		List<Destination> ld =dao.getDestinationByRegion(region);
		
		return ld;
		
		
	}
	
	public void update(long id){
		LOG.info("maj effectuée" + id);
		Destination d=dao.getDestinationById(id);
		try {
			dao.saveOrUpdate(d);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save(Destination d){
		LOG.info("sauvegarde effectuée" +d.getId());
		try {
			dao.saveOrUpdate(d);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void remove(long id) {
		LOG.info("suppression effectuée"+id);
		try {
			dao.remove(id);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Destination> getAll(){
		
		List<Destination> ld =dao.getAll();
		return ld;
		
	}

}
