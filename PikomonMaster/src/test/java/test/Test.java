package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Arene;
import model.Centre;
import model.Dresseur;
import model.Infirmiere;
import model.Item;
import model.Pokemon;
import model.Type;
import model.Ville;

public class Test {

	public static void main(String[] args) {
		
		Infirmiere inf = new Infirmiere("Joelle");
		Centre centre = new Centre(inf);
		Ville v1 = new Ville("Relifac-le-haut",centre);
		
		Dresseur matthieu = new Dresseur("Matthieu", LocalDate.parse("1998-02-23"),10, v1);
		Pokemon p1 = new Pokemon("Dracolosse", 150, 100, Type.Dragon);
		Pokemon p2 = new Pokemon("Amphinobi",120,70,Type.Eau);
		Pokemon p3 = new Pokemon ("Exagide",130,80,Type.Acier);
		List<Pokemon> pokemons= new ArrayList();
		Collections.addAll(pokemons, p1,p2,p3);
		matthieu.setEquipe(pokemons);
		Item i1 = new Item("potion");
		Item i2 = new Item("PokeBall");
		Item i3= new Item("MasterBall");
		List<Item> inventaire = new ArrayList();
		inventaire.add(i1);
		inventaire.add(i2);
		inventaire.add(i3);
		matthieu.setInventaire(inventaire);
		
		Infirmiere inf2 = new Infirmiere("Joelle");
		Centre centre2 = new Centre(inf2);
		
		Ville v2 = new Ville("Carmin-sur-mer",centre2);
		Dresseur ismail  = new Dresseur("Ismail",LocalDate.parse("1996-02-16"),11,v2);
		Pokemon p4 = new Pokemon("Dracaufeu",99999,120,Type.Feu);
		Pokemon p5 = new Pokemon ("Herbizare",120,100,Type.Plante);
		Pokemon p6 = new Pokemon("Carapuce",60,80,Type.Eau);
		
		List<Pokemon> pokemons2= new ArrayList();
		Collections.addAll(pokemons2, p4,p5,p6);
		
		Arene arene = new Arene(1, Type.Ismail, v2, ismail);
		
		
		
		
				
		
		
		
		
		
		
	}

}
