package centerpark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import centerpark.exception.ActiviteException;
import centerpark.model.Activite;
import centerpark.repositories.ActiviteRepository;
import centerpark.repositories.ReservationRepository;

@Service
public class ActiviteService {

	@Autowired
	private ActiviteRepository activiteRepo;
	@Autowired
	private ReservationRepository reservationRepo;

	public List<Activite> getAll() {
		return activiteRepo.findAll();
	}

	public Activite getById(Integer id) {
		return activiteRepo.findById(id).orElseThrow(ActiviteException::new);
	}

	public Activite save(Activite activite) {
		if (activite.getId() != null) {
			Activite activiteEnBase = getById(activite.getId());
			activite.setVersion(activiteEnBase.getVersion());
		}
		return activiteRepo.save(activite);
	}

	public void delete(Activite activite) {
		reservationRepo.deleteByActivite(activite);
		delete(activite);
	}

	public void delete(Integer id) {
		delete(getById(id));
	}
}
