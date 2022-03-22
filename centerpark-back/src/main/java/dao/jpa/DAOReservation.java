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
		Reservation r = em.find(Reservation.class, id);
		em.close();
		return r;
	}

	@Override
	public List<Reservation> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Reservation> arenes = em.createQuery("SELECT r from Reservation r").getResultList();
		em.close();
		return arenes;
	}

	@Override
	public Reservation insert(Reservation r) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
		return r;
	}

	@Override
	public Reservation update(Reservation r) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();

		try {
			em.getTransaction().begin();

			r = em.merge(r);
			em.getTransaction().commit();
		}catch(Exception e) {e.printStackTrace();}
		em.close();
		return r;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Reservation r = em.find(Reservation.class, id);
		try{
			em.remove(r);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
		}
		em.close();
	}

	@Override
	public List<Reservation> findAllReservationClient(int id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT r from Reservation r where r.client.numero = :id");
		q.setParameter("id", id);
		List<Reservation> arenes = q.getResultList();
		em.close();
		return arenes;
	}

}
