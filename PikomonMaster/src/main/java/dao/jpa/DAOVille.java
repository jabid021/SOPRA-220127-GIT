package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOVille;
import model.Pokemon;
import model.Type;
import model.Ville;
import util.Context;

public class DAOVille implements IDAOVille {

	@Override
	public Ville findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Ville v = em.find(Ville.class, id);
		em.close();
		return v;
	}

	@Override
	public List<Ville> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Ville> villes = em.createQuery("SELECT v from Ville v").getResultList();
		em.close();
		return villes;
	}

	@Override
	public Ville save(Ville v) {
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
		Ville v = em.find(Ville.class, id);
		em.remove(v);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Ville findByName(String name) {
		Ville ville = null;
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT v from Ville v where v.nom = :nom");
		q.setParameter("nom", name);
		try {
		 ville = (Ville) q.getSingleResult();
		}
		catch(Exception e) {System.out.println("Aucune ville ne porte ce nom");}
		em.close();
		return ville;
	}

	@Override
	public List<Ville> findByTypeArene(Type type) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT v from Ville v where v.arene.type = :type");
		q.setParameter("type", type);
		List<Ville> villes = q.getResultList();
		em.close();
		return villes;
	}

}
