package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOReservation;
import model.Reservation;
import util.Context;

public class DAOReservation implements IDAOReservation {

	@Override
	public Reservation findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Reservation o = em.find(Reservation.class, id);
		em.close();
		return o;
	}

	@Override
	public List<Reservation> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Reservation> arenes = em.createQuery("SELECT o from Reservation o").getResultList();
		em.close();
		return arenes;
	}

	@Override
	public Reservation insert(Reservation o) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public Reservation update(Reservation o) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		o = em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Reservation o = em.find(Reservation.class, id);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Reservation> findAllReservationClient(int id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT o from Reservation o where o.reservation.client = :id");
		q.setParameter("id", id);
		List<Reservation> arenes = q.getResultList();
		em.close();
		return arenes;
	}

}
