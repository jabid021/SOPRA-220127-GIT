package pikomon.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pikomon.dao.IDAOPokemon;
import pikomon.model.Pokemon;
import util.Context;

public class DAOPokemon implements IDAOPokemon {

	@Override
	public Pokemon findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Pokemon p = em.find(Pokemon.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Pokemon> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Pokemon> pokemons = em.createQuery("SELECT p from Pokemon p").getResultList();
		em.close();
		return pokemons;
	}

	@Override
	public Pokemon save(Pokemon p) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		p = em.merge(p);
		em.getTransaction().commit();
		em.close();
		return p;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Pokemon p = em.find(Pokemon.class, id);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Pokemon> findByNameLike(String lettres) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT p from Pokemon p where p.nom like :mot");
		q.setParameter("mot", "%"+lettres+"%");
		List<Pokemon> pokemons = q.getResultList();
		em.close();
		return pokemons;
	}

}
