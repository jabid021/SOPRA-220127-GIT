package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.jpa.DAOReservation;
import model.Activite;
import model.Aquatique;
import model.Client;
import model.Participant;
import model.Reservation;

public class TestJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("centerpark");
		EntityManager em = emf.createEntityManager();
		
		
		//Sanglier s = new Sanglier("Pumba3");
		//Context.getSingleton().getDaoAnimal().save(s);
		Animal a = Context.getSingleton().getDaoAnimal().findById(2);
		Context.getSingleton().getDaoAnimal().delete(2);
		
		System.out.println(a);
		System.out.println("-------");
		for(Animal an : Context.getSingleton().getDaoAnimal().findAll()) {System.out.println(an);}
		
		
		
		Context.getSingleton().close();
	}

}
