package centerpark.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import centerpark.model.Activite;
import centerpark.model.Client;
import centerpark.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	@Modifying
	@Transactional
	@Query("delete from Reservation r where r.client=:client")
	void deleteByClient(@Param("client") Client client);
	
	@Modifying
	@Transactional
	@Query("delete from Reservation r where r.activite=:activite")
	void deleteByActivite(@Param("activite") Activite activite);
	
	
	@Modifying
	@Transactional
	@Query("update Reservation r set r.client=null where r.client=:client")
	void setClientReservationToNull(@Param("client")Client client);
}
