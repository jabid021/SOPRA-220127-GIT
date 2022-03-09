package test;

import dao.IDAOCompte;
import model.Compte;
import util.Context;

import dao.jpa.DAOReservation;
import model.Activite;
import model.Aquatique;
import model.Client;
import model.Participant;
import model.Reservation;

public class TestJPA {

	static IDAOCompte daoCompte = Context.getSingleton().getDaoCompte();
	public static void main(String[] args) {
		
	
		Compte c = Context.getSingleton().getDaoCompte().seConnecter("client@client", "client");
		System.out.println(c.getNumero());
		Context.getSingleton().close();
		
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
