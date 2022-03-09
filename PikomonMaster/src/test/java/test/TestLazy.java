package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Dresseur;
import util.Context;

public class TestLazy {


	//Acces à l'equipe et à l'inventaire AVANT le em.close
	//Impossible de faire des filtres sur les pokemons / items
	public static List<Dresseur> showLazy()
	{
		List<Dresseur> dresseurs=null;
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();


		Query q = em.createQuery("from Dresseur ");
		dresseurs=q.getResultList();
		em.close();

		return dresseurs;

	}


	//Acces à l'equipe et à l'inventaire AVANT le em.close
	//possible de faire des filtres sur les pokemons / items
	//Doublons de dresseurs si il a plusieurs pokemon 
	//Les dresseurs n'ayant pas de pokemon en AR NE sont pas recup
	public static List<Dresseur> showJoin()
	{
		List<Dresseur> dresseurs=null;
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();


		Query q = em.createQuery("SELECT d from Dresseur d JOIN d.equipe poke where poke.nom like '%ar%'");
		dresseurs=q.getResultList();
		em.close();

		return dresseurs;

	}

	//Acces à l'equipe et à l'inventaire AVANT le em.close
	//possible de faire des filtres sur les pokemons / items
	//PLUS Doublons de dresseurs si il a plusieurs items 
	//Les dresseurs n'ayant pas d'items  NE sont pas recup
	public static List<Dresseur> showJoinSansDoublon()
	{
		List<Dresseur> dresseurs=null;
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();


		Query q = em.createQuery("SELECT Distinct d from Dresseur d JOIN d.inventaire");
		dresseurs=q.getResultList();
		em.close();

		return dresseurs;

	}

	//Acces à l'equipe et à l'inventaire AVANT le em.close
	//possible de faire des filtres sur les pokemons / items
	//PLUS Doublons de dresseurs si il a plusieurs items 
	//Les dresseurs n'ayant pas d'items  sont pas recup
	public static List<Dresseur> showLeftJoinSansDoublon()
	{
		List<Dresseur> dresseurs=null;
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();


		Query q = em.createQuery("SELECT Distinct d from Dresseur d LEFT JOIN d.inventaire");
		dresseurs=q.getResultList();
		em.close();

		return dresseurs;

	}


	//Acces à l'equipe et à l'inventaire APRES le em.close
	//possible de faire des filtres sur les pokemons / items
	//PLUS Doublons de dresseurs si il a plusieurs items 
	//Les dresseurs n'ayant pas d'items sont pas recup
	public static List<Dresseur> showLeftJoinFetchSansDoublon()
	{
		List<Dresseur> dresseurs=null;
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();


		Query q = em.createQuery("SELECT Distinct d from Dresseur d LEFT JOIN FETCH d.inventaire");
		dresseurs=q.getResultList();
		em.close();

		return dresseurs;

	}
	
	
		public static List<Dresseur> showLeftJoinFetchSansDoublonPokemonEtInventaireNOTWORKING()
		{
			List<Dresseur> dresseurs=null;
			EntityManager em = Context.getSingleton().getEmf().createEntityManager();


			Query q = em.createQuery("SELECT Distinct d from Dresseur d LEFT JOIN FETCH d.inventaire LEFT JOIN FETCH d.equipe");
			dresseurs=q.getResultList();
			em.close();

			return dresseurs;

		}
		
		public static List<Dresseur> showLeftJoinFetchSansDoublonPokemonEtInventaireWORKING()
		{
			List<Dresseur> dresseurs=null;
			EntityManager em = Context.getSingleton().getEmf().createEntityManager();


			Query q = em.createQuery("SELECT  DISTINCT d from Dresseur d LEFT JOIN FETCH d.inventaire");
			dresseurs=q.getResultList();
			
			q = em.createQuery("SELECT d from Dresseur d LEFT JOIN FETCH d.equipe");
			dresseurs=q.getResultList();
			em.close();

			return dresseurs;

		}




	public static void main(String[] args) {
		List<Dresseur> dresseurs=showLeftJoinFetchSansDoublonPokemonEtInventaireWORKING();

		for(Dresseur d : dresseurs) 
		{
			System.out.println(d.getNom());
			System.out.println(d.getNaissance());
			System.out.println("Equipe du dresseur : ");
			System.out.println(d.getEquipe());
			System.out.println(d.getInventaire());
		}

		Context.getSingleton().close();
	}

}
