package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		
		Infirmiere inf = new Infirmiere("Joelle1");
		Centre centre = new Centre(inf);
		Ville v1 = new Ville("Relifac-le-haut",centre);
		
		Dresseur matthieu = new Dresseur("Matthieu", LocalDate.parse("1998-02-23"),10, v1);
		Pokemon p1 = new Pokemon("Dracolosse", 150, 100, Type.Dragon);
		Pokemon p2 = new Pokemon("Amphinobi",120,70,Type.Eau);
		Pokemon p3 = new Pokemon ("Exagide",130,80,Type.Acier);
		p1.setDresseur(matthieu);
		p2.setDresseur(matthieu);
		p3.setDresseur(matthieu);
		
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
		
		Infirmiere inf2 = new Infirmiere("Joelle2");
		Centre centre2 = new Centre(inf2);
		
		Infirmiere inf3 = new Infirmiere("Joelle3");
		
		Ville v2 = new Ville("Carmin-sur-mer",centre2);
		Dresseur ismail  = new Dresseur("Ismail",LocalDate.parse("1996-02-16"),11,v2);
		Pokemon p4 = new Pokemon("Dracaufeu",99999,120,Type.Feu);
		Pokemon p5 = new Pokemon ("Herbizare",120,100,Type.Plante);
		Pokemon p6 = new Pokemon("Carapuce",60,80,Type.Eau);
		
		p4.setDresseur(ismail);
		p5.setDresseur(ismail);
		p6.setDresseur(ismail);
		
		List<Pokemon> pokemons2= new ArrayList();
		Collections.addAll(pokemons2, p4,p5,p6);
		ismail.setEquipe(pokemons2);
		
		Arene arene = new Arene(1, Type.Mixte, v2, ismail);
		
		
		
		
			
		
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("demoJPA");
		
		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		em.persist(v1);
		em.persist(v2);
		
		em.persist(centre);
		em.persist(centre2);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		em.persist(p6);
		
		em.persist(i1);
		em.persist(i2);
		em.persist(i3);
		
		em.persist(arene);
	
		em.persist(matthieu);
		em.persist(ismail);
		em.persist(inf);
		em.persist(inf2);
		em.persist(inf3);
		em.getTransaction().commit();
		
		
		
		
		System.out.println(em.find(Pokemon.class, 1));
		
		em.close();
		emf.close();
		
		
		
		
		
		
	}

}
