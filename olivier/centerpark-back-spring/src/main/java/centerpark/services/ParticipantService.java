package centerpark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import centerpark.exception.ParticipantException;
import centerpark.model.Participant;
import centerpark.repositories.ParticipantRepository;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository participantRepo;

	public List<Participant> getAll() {
		return participantRepo.findAll();
	}

	public Participant getById(Integer id) {
		return participantRepo.findById(id).orElseThrow(ParticipantException::new);
	}

	public Participant save(Participant participant) {
		if (participant.getId() != null) {
			Participant participantEnBase = getById(participant.getId());
			participant.setVersion(participantEnBase.getVersion());
		}
		return participantRepo.save(participant);
	}

	public void delete(Participant participant) {
		delete(participant.getId());
	}

	public void delete(Integer id) {
		participantRepo.deleteById(id);
	}
}
