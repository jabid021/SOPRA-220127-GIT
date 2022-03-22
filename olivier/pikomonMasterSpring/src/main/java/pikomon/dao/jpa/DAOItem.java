package pikomon.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import pikomon.dao.IDAOItem;
import pikomon.model.Item;
import util.Context;

public class DAOItem implements IDAOItem {

	@Override
	public Item findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Item i = em.find(Item.class, id);
		em.close();
		return i;
	}

	@Override
	public List<Item> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Item> items = em.createQuery("SELECT i from Item i").getResultList();
		em.close();
		return items;
	}

	@Override
	public Item save(Item i) {
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
		Item i = em.find(Item.class, id);
		em.remove(i);
		em.getTransaction().commit();
		em.close();
	}

}
