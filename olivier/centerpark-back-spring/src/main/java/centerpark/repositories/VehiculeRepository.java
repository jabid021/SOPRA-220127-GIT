package centerpark.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import centerpark.model.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
	@Query("select v from Vehicule v left join fetch v.safaris where v.id=:id")
	public Optional<Vehicule> findByIdWithSafari(@Param("id") Integer id);
}
