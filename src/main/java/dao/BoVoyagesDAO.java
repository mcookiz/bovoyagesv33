package dao;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import entities.Destination;

@Dependent
public class BoVoyagesDAO {
	@PersistenceContext(unitName = "bovoyage") private EntityManager em;
	@Resource private UserTransaction ut;
	

	public Destination getDestinationById(long id) {
		Destination destination = em.find(Destination.class, id);

		em.close();

		return destination;

	}

	public List<Destination> getDestinationByRegion(String region) {
		Query q = em.createNamedQuery("getDestinationByRegion");
		q.setParameter("region", region);
		List<Destination> ld = q.getResultList();
		em.close();
		return ld;

	}

	public void saveOrUpdate(Destination d) throws NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		ut.begin();
		if (d.getId() == 0) {
			em.persist(d);
		}

		else {
			em.merge(d);
		}
		ut.commit();

	}

	public void remove(long id) throws NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {

		ut.begin();
		em.remove(id);
		ut.commit();
	}

	
	public List<Destination> getAll(){
		
		Query q = em.createNamedQuery("getAll");
		List<Destination> ld =q.getResultList();
		
		em.close();
		return ld;}
}
