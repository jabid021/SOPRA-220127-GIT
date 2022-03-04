package dao;

import java.util.List;

import model.Activite;
import model.Aquatique;

public interface IDAOActivite extends IDAO<Activite,Integer> {
	
	public List<Activite> findAllDisponibles();

	public Activite insertAquatique(Activite a);
	public Activite insertSafari(Activite a);
}
