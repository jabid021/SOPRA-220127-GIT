package centerpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import centerpark.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

}
