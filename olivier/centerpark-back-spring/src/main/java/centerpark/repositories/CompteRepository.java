package centerpark.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import centerpark.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {

	Optional<Compte> findByMail(String mail);

	Optional<Compte> findByMailAndPassword(String mail, String password);

	List<Compte> findByMailContaining(String texte);
}
