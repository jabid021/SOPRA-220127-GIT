package pikomon.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import pikomon.dao.IDAOCentre;
import pikomon.model.Centre;
import util.Context;

public class DAOCentre implements IDAOCentre {

	@Override
	public Centre findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Centre c = em.find(Centre.class, id);
		em.close();
		return c;
	}

	@Override
	public List<Centre> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Centre> centres = em.createQuery("SELECT c from Centre c").getResultList();
		em.close();
		return centres;
	}

	@Override
	public Centre save(Centre c) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		c = em.merge(c);
		em.getTransaction().commit();
		em.close();
		return c;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Centre c = em.find(Centre.class, id);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

}
