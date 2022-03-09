package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Arene;
import model.Centre;
import model.Dresseur;
import model.Infirmiere;
import model.Item;
import model.Pokemon;
import model.Type;
import model.Ville;
import util.Context;

public class Test {

	
	public static void initBdd() 
	{
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
		
		
		Arene arene = new Arene(1, Type.Mixte, v2, ismail);
		
		
		
		
			
		
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("demoJPA");
		
		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
	
		
		//em.persist(centre);
		//em.persist(centre2);
		
		em.persist(v1);
		em.persist(v2);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		em.persist(p6);
		
		em.persist(arene);
		//em.persist(i1);
		//em.persist(i2);
		//em.persist(i3);
		
		
	
		//em.persist(matthieu);
		
		//em.persist(ismail);
		
		//em.persist(inf);
		//em.persist(inf2);
		//em.persist(inf3);
		
		
		em.getTransaction().commit();
		
		System.out.println(em.find(Pokemon.class, 1));

		em.close();
		emf.close();
	
	}
	
	public static void demoRequetes() 
	{
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("demoJPA");
		EntityManager em = emf.createEntityManager();
	
		Infirmiere inf = new Infirmiere("test");
		
		//---------INSERT UNIQUEMENT (sans id si auto, avec id sinon) / Plante si l'id existe deja--------*
		
		em.getTransaction().begin();
		//Insert (sans id si auto, avec id sinon)
		
		//em.persist(inf);
		em.getTransaction().commit();
		em.close();
		//----------------------------------------------
		
		
		
		//---------UPDATE (ou insert si l'id n'existe pas)--------
		em = emf.createEntityManager();
		Infirmiere i = em.find(Infirmiere.class, 52);
		
		em.getTransaction().begin();
		//Update
		i.setNom("Nouveau Nom");
		//em.merge(inf);
		em.getTransaction().commit();
		em.close();
		//-----------------------------------------------------
		
		
		
		//---------------FINDALL----------------
		
		em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p from Pokemon p where p.nom like '%ra%'");
		List<Pokemon> pokes= q.getResultList();
		for(Pokemon p : pokes) 
		{
			System.out.println(p.getNom());
		}
		em.close();
		//--------------
		
		
		
		//--------------DELETE 1-------------------
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Infirmiere iDelete = em.find(Infirmiere.class, 202);
		em.remove(iDelete);
		em.getTransaction().commit();
		
		emf.close();
		//------------------------------------------
		
		

		//--------------DELETE 2-------------------
		em = emf.createEntityManager();
		em.getTransaction().begin();
		//Infirmiere infCopie = em.merge(i);
		i=em.merge(i);
		em.remove(i);
		em.getTransaction().commit();
		
		emf.close();
		//------------------------------------------
		
		
		//em.persit(x) => x est managed
		//em.find(X.class,id) => l'objet retourné il est managed
		// List<X> list = em.getResultList() => Tous les objets managed
		//xCopie = em.merge(x) => x n'est pas managed, par contre xCopie l'est !
	}
	public static void main(String[] args) {
		
	
		List<Pokemon> pokes = Context.getSingleton().getDaoPokemon().findByNameLike("ra");
		for(Pokemon p : pokes) 
		{
			System.out.println(p.getNom());
		}
		
		Ville v = Context.getSingleton().getDaoVille().findByName("Carmin-sur-merr");
		System.out.println(v);
	
		List<Ville> villes = Context.getSingleton().getDaoVille().findByTypeArene(Type.Mixte);
		for(Ville vi : villes) 
		{
			System.out.println(vi.getNom()+" - "+vi.getArene().getMaitre().getNom());
		}
		
		Context.getSingleton().close();
	}

}
