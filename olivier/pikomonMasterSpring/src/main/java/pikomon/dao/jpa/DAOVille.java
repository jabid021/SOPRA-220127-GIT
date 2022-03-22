package pikomon.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pikomon.dao.IDAOVille;
import pikomon.model.Pokemon;
import pikomon.model.Type;
import pikomon.model.Ville;

@Repository
public class DAOVille implements IDAOVille {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Ville findById(Integer id) {
		return em.find(Ville.class, id);
	}

	@Override
	public List<Ville> findAll() {
		return em.createQuery("SELECT v from Ville v").getResultList();
	}

	@Override
	@Transactional
	public Ville save(Ville v) {
		if (v.getId() == null) {
			em.persist(v);
		} else {
			v = em.merge(v);
		}
		return v;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Ville v = em.find(Ville.class, id);
		em.remove(v);
	}

	@Override
	public Ville findByName(String name) {
		Ville ville = null;
		Query q = em.createQuery("SELECT v from Ville v where v.nom = :nom");
		q.setParameter("nom", name);
		try {
			ville = (Ville) q.getSingleResult();
		} catch (Exception e) {
			System.out.println("Aucune ville ne porte ce nom");
		}
		return ville;
	}

	@Override
	public List<Ville> findByTypeArene(Type type) {
		Query q = em.createQuery("SELECT v from Ville v where v.arene.type = :type");
		q.setParameter("type", type);
		List<Ville> villes = q.getResultList();
		return villes;
	}

}
