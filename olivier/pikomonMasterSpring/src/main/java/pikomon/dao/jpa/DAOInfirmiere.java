package pikomon.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import pikomon.dao.IDAOInfirmiere;
import pikomon.model.Infirmiere;
import util.Context;

public class DAOInfirmiere implements IDAOInfirmiere {

	@Override
	public Infirmiere findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Infirmiere i = em.find(Infirmiere.class, id);
		em.close();
		return i;
	}

	@Override
	public List<Infirmiere> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Infirmiere> infirmieres = em.createQuery("SELECT i from Infirmiere i").getResultList();
		em.close();
		return infirmieres;
	}

	@Override
	public Infirmiere save(Infirmiere i) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		i = em.merge(i);
		em.getTransaction().commit();
		em.close();
		return i;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Infirmiere i = em.find(Infirmiere.class, id);
		em.remove(i);
		em.getTransaction().commit();
		em.close();
	}

}
