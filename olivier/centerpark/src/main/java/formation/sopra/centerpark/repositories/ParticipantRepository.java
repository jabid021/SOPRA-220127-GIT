package formation.sopra.centerpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.centerpark.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

}
