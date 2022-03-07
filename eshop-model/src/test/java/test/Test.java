package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personne;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopUnit");
		EntityManager em = emf.createEntityManager();
		
		Personne p1 = new Personne("Abid","Jordan");
		
		em.getTransaction().begin();
		
		em.persist(p1);
		
		em.getTransaction().commit();
		
		System.out.println(em.find(Personne.class, 1));
		
		em.close();
		emf.close();
	}

}
