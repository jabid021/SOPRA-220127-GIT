package centerpark.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import centerpark.dao.IDAOReservation;
import centerpark.model.Reservation;

@Repository
public class DAOReservation implements IDAOReservation {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Reservation findById(Integer id) {
		Reservation r = em.find(Reservation.class, id);
		return r;
	}

	@Override
	public List<Reservation> findAll() {
		List<Reservation> arenes = em.createQuery("SELECT r from Reservation r").getResultList();
		return arenes;
	}

	@Override
	@Transactional
	public Reservation insert(Reservation r) {
		em.persist(r);
		return r;
	}

	@Override
	@Transactional
	public Reservation update(Reservation r) {
		r = em.merge(r);
		return r;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Reservation r = em.find(Reservation.class, id);
		em.remove(r);
	}

	@Override
	public List<Reservation> findAllReservationClient(int id) {
		Query q = em.createQuery("SELECT r from Reservation r where r.client.numero = :id");
		q.setParameter("id", id);
		List<Reservation> arenes = q.getResultList();
		return arenes;
	}

}
