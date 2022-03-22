package centerpark.dao;

import java.util.List;

import centerpark.model.Reservation;

public interface IDAOReservation extends IDAO<Reservation,Integer> {

	public List<Reservation> findAllReservationClient(int id);
}
