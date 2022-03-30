package centerpark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import centerpark.exception.VehiculeException;
import centerpark.model.Vehicule;
import centerpark.repositories.VehiculeRepository;

@Service
public class VehiculeService {

	@Autowired
	private VehiculeRepository vehiculeRepo;

	public List<Vehicule> getAll() {
		return vehiculeRepo.findAll();
	}

	public Vehicule getByIdWithSafari(Integer id) {
		return vehiculeRepo.findByIdWithSafari(id).orElseThrow(VehiculeException::new);
	}

	public Vehicule getById(Integer id) {
		return vehiculeRepo.findById(id).orElseThrow(VehiculeException::new);
	}

	public Vehicule save(Vehicule vehicule) {
		if (vehicule.getId() != null) {
			Vehicule vehiculeEnBase = getById(vehicule.getId());
			vehicule.setVersion(vehiculeEnBase.getVersion());
		}
		return vehiculeRepo.save(vehicule);
	}

	public void delete(Vehicule vehicule) {
		delete(vehicule.getId());
	}

	public void delete(Integer id) {
		vehiculeRepo.deleteById(id);
	}
}
