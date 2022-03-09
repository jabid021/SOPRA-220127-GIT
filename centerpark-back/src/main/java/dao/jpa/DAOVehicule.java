package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOVehicule;
import model.Vehicule;
import util.Context;

public class DAOVehicule implements IDAOVehicule{

	@Override
	public Vehicule findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Vehicule v = em.find(Vehicule.class, id);
		em.close();
		return v;
	}

	@Override
	public List<Vehicule> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Vehicule> vehicules = em.createQuery("SELECT v from Vehicule v").getResultList();
		em.close();
		return vehicules;
	}
	
	@Override
	public Vehicule insert(Vehicule v) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
		return v;
	}
	@Override
	public Vehicule update(Vehicule v) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		v = em.merge(v);
		em.getTransaction().commit();
		em.close();
		return v;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Vehicule v = em.find(Vehicule.class, id);
		em.remove(v);
		em.getTransaction().commit();
		em.close();
	}

}
