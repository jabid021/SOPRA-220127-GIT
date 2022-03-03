package dao;

import java.util.List;

import model.Reservation;

public interface IDAOReservation extends IDAO<Reservation,Integer> {

	public List<Reservation> findAllReservationClient(int id);
}
