package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;
import model.Fournisseur;
import model.Personne;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopUnit");
		EntityManager em = emf.createEntityManager();
		
		Fournisseur p1 = new Fournisseur("Abid","Jordan","AJC");
		Client c1 = new Client("Doe","John",42,LocalDate.parse("1980-01-01"));
		
		
		em.getTransaction().begin();
		
		em.persist(p1);
		em.persist(c1);
		
		em.getTransaction().commit();
		
		System.out.println(em.find(Personne.class, 1));
		
		em.close();
		emf.close();
	}

}
