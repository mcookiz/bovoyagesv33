package dao;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import entities.Destination;

public interface IBoVoyagesDAO {

	Destination getDestinationById(long id);

	List<Destination> getDestinationByRegion(String region);

	void saveOrUpdate(Destination d) throws NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	void remove(long id) throws NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;

	List<Destination> getAll();

}