package formation.sopra.centerpark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.centerpark.exception.ActiviteException;
import formation.sopra.centerpark.model.Activite;
import formation.sopra.centerpark.model.Aquatique;
import formation.sopra.centerpark.model.Safari;
import formation.sopra.centerpark.repositories.ActiviteRepository;
import formation.sopra.centerpark.repositories.AquatiqueRepository;
import formation.sopra.centerpark.repositories.ReservationRepository;
import formation.sopra.centerpark.repositories.SafariRepository;

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
