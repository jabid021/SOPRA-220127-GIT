package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAODresseur;
import model.Dresseur;
import util.Context;

public class DAODresseur implements IDAODresseur {

	@Override
	public Dresseur findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Dresseur d = em.find(Dresseur.class, id);
		em.close();
		return d;
	}

	@Override
	public List<Dresseur> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Dresseur> dresseurs = em.createQuery("SELECT d from Dresseur d").getResultList();
		em.close();
		return dresseurs;
	}

	@Override
	public Dresseur save(Dresseur d) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		d = em.merge(d);
		em.getTransaction().commit();
		em.close();
		return d;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Dresseur d = em.find(Dresseur.class, id);
		em.remove(d);
		em.getTransaction().commit();
		em.close();
	}

}
