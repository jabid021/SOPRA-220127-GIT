package pikomon.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import pikomon.dao.IDAOArene;
import pikomon.model.Arene;
import util.Context;

public class DAOArene implements IDAOArene {

	@Override
	public Arene findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Arene a = em.find(Arene.class, id);
		em.close();
		return a;
	}

	@Override
	public List<Arene> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Arene> arenes = em.createQuery("SELECT a from Arene a").getResultList();
		em.close();
		return arenes;
	}

	@Override
	public Arene save(Arene a) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		a = em.merge(a);
		em.getTransaction().commit();
		em.close();
		return a;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Arene a = em.find(Arene.class, id);
		em.remove(a);
		em.getTransaction().commit();
		em.close();
	}

}
