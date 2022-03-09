package dao;

import java.util.List;

import model.Pokemon;

public interface IDAOPokemon extends IDAO<Pokemon,Integer> {

	public List<Pokemon>findByNameLike(String lettres);
}
