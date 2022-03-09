package dao;

import java.util.List;

import model.Type;
import model.Ville;

public interface IDAOVille extends IDAO<Ville,Integer> {

	public Ville findByName(String name);
	
	public List<Ville> findByTypeArene(Type type);
}
