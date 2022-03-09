package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOActivite;
import dao.IDAOCompte;
import model.Activite;
import util.Context;

public class DAOActivite implements IDAOActivite {

	@Override
	public Activite findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Activite a = em.find(Activite.class, id);
		em.close();
		return a;
	}

	@Override
	public List<Activite> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Activite> Activites = em.createQuery("SELECT a from Activite a").getResultList();
		em.close();
		return Activites;
	}

	@Override
	public Activite insert(Activite a) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
		return a;
	}

	@Override
	public Activite update(Activite a) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();

		try {
			em.getTransaction().begin();

			a = em.merge(a);
			em.getTransaction().commit();
		}catch(Exception e) {e.printStackTrace();}
		em.close();
		return a;
	}




	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Activite a = em.find(Activite.class, id);
		em.remove(a);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Activite> findAllDisponibles() {

		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Activite> Activites = em.createQuery("SELECT a from Activite a WHERE a.date > now() ").getResultList();
		em.close();
		return Activites;

	}

	@Override
	public Activite insertAquatique(Activite a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activite insertSafari(Activite a) {
		// TODO Auto-generated method stub
		return null;
	}




}
