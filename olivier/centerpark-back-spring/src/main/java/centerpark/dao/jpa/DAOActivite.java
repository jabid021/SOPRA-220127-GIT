package centerpark.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import centerpark.dao.IDAOActivite;
import centerpark.model.Activite;

@Repository
public class DAOActivite implements IDAOActivite {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Activite findById(Integer id) {
		Activite a = em.find(Activite.class, id);
		return a;
	}

	@Override
	public List<Activite> findAll() {
		List<Activite> Activites = em.createQuery("SELECT a from Activite a").getResultList();
		return Activites;
	}

	@Override
	@Transactional
	public Activite insert(Activite a) {
		em.persist(a);
		return a;
	}

	@Override
	@Transactional
	public Activite update(Activite a) {
		a = em.merge(a);
		return a;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Activite a = em.find(Activite.class, id);
		em.remove(a);
	}

	@Override
	public List<Activite> findAllDisponibles() {
		List<Activite> Activites = em.createQuery("SELECT a from Activite a WHERE a.date > now() ").getResultList();
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
