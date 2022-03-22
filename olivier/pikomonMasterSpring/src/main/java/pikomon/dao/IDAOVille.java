package pikomon.dao;

import java.util.List;

import pikomon.model.Type;
import pikomon.model.Ville;

public interface IDAOVille extends IDAO<Ville,Integer> {

	public Ville findByName(String name);
	
	public List<Ville> findByTypeArene(Type type);
}
