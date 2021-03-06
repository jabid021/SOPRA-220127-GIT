package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOParticipant;
import model.Participant;
import util.Context;

public class DAOParticipant implements IDAOParticipant{

	@Override
	public Participant findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Participant p = em.find(Participant.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Participant> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Participant> Participants = em.createQuery("SELECT p from Participant p").getResultList();
		em.close();
		return Participants;
	}


	@Override
	public Participant insert(Participant p) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		return p;
	}

	@Override
	public Participant update(Participant p) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();

		try {
			em.getTransaction().begin();

			p = em.merge(p);
			em.getTransaction().commit();
		}catch(Exception e) {e.printStackTrace();}
		em.close();
		return p;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Participant p = em.find(Participant.class, id);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}
}
