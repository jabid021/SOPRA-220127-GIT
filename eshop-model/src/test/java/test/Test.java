package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Client;
import model.Fournisseur;
import model.Personne;
import model.Produit;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopUnit");
		EntityManager em = emf.createEntityManager();
		Adresse a1 = new Adresse("6","rue rougememont","75009","Paris");
		Adresse a2 = new Adresse("12","rue de paris","75016","Paris");
		
		Fournisseur p1 = new Fournisseur("Abid","Jordan","AJC",a1);
		
		Produit pr1=new Produit("Iphone",1300,p1);
		
		Produit pr2=new Produit("Xiaomi",120,p1);
		
		Produit pr3=new Produit("Samsung S22",1250,p1);
		
	
		Client c1 = new Client("Doe","John",42,LocalDate.parse("1980-01-01"),a2);
		
		List<Produit> panier = new ArrayList();
		Collections.addAll(panier, pr1,pr2,pr3);
		c1.setAchats(panier);
		
		
		em.getTransaction().begin();
		
	
		em.persist(p1);
		
		em.persist(pr1);
		em.persist(pr2);
		em.persist(pr3);
		
		em.persist(c1);
		
		em.getTransaction().commit();
		

		
		em.close();
		emf.close();
	}

}
