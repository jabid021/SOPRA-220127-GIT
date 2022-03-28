package centerpark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import centerpark.exception.ActiviteException;
import centerpark.model.Activite;
import centerpark.model.Aquatique;
import centerpark.model.Safari;
import centerpark.repositories.ActiviteRepository;
import centerpark.repositories.AquatiqueRepository;
import centerpark.repositories.ReservationRepository;
import centerpark.repositories.SafariRepository;

@Service
public class ActiviteService {

	@Autowired
	private ActiviteRepository activiteRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private AquatiqueRepository aquatiqueRepository;
	@Autowired
	private SafariRepository safariRepository;

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
		activiteRepo.delete(activite);
	}

	public void delete(Integer id) {
		delete(getById(id));
	}

	public List<Aquatique> getAllAquatique() {
		return aquatiqueRepository.findAll();
	}

	public List<Safari> getAllSafari() {
		return safariRepository.findAll();
	}
}
