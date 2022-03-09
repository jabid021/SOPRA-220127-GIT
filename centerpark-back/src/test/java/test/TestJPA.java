package test;

import java.time.LocalDate;
import java.util.List;

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
		
		
		
		em.close();
		emf.close();
	}

}
