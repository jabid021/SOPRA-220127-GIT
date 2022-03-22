package centerpark.dao;

import java.util.List;

import centerpark.model.Activite;
import centerpark.model.Aquatique;

public interface IDAOActivite extends IDAO<Activite,Integer> {
	
	public List<Activite> findAllDisponibles();

	public Activite insertAquatique(Activite a);
	public Activite insertSafari(Activite a);
}
