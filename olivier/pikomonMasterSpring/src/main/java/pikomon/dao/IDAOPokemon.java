package pikomon.dao;

import java.util.List;

import pikomon.model.Pokemon;

public interface IDAOPokemon extends IDAO<Pokemon,Integer> {

	public List<Pokemon>findByNameLike(String lettres);
}
