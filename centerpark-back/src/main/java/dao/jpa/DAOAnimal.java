package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOAnimal;
import model.Animal;
import util.Context;

public class DAOAnimal implements IDAOAnimal{

	@Override
	public Animal findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Animal a = em.find(Animal.class, id);
		em.close();
		return a;
	}

	@Override
	public List<Animal> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Animal> Animals = em.createQuery("SELECT a from Animal a").getResultList();
		em.close();
		return Animals;
	}

	@Override
	public Animal save(Animal a) {
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
		Animal a = em.find(Animal.class, id);
		em.remove(a);
		em.getTransaction().commit();
		em.close();
	}
}
