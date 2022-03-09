package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Activite;
import model.Aquatique;
import model.Meteo;
import util.Context;

public class TestJPA {

	public static void main(String[] args) {
			
		/*
		Activite a = Context.getSingleton().getDaoActivite().findById(1);
		System.out.println(a.getClass());
		
		List <Activite> activites = Context.getSingleton().getDaoActivite().findAll();
		for(Activite ac : activites) {
			System.out.println(ac.getPrix());
			
		}
		*/
		
		//Activite a1 = new Aquatique(Meteo.Neige, LocalDate.parse("2022-03-10"), LocalTime.parse("12:00"),10);
				
		//Activite a = Context.getSingleton().getDaoActivite().insert(a1);
		
		/*
		Activite a3 = Context.getSingleton().getDaoActivite().findById(3);
		a3.setPrix(1000);
		Context.getSingleton().getDaoActivite().update(a3);
		*/
		
		//Context.getSingleton().getDaoActivite().delete(3);
		
		/*
		List <Activite> activites = Context.getSingleton().getDaoActivite().findAllDisponibles();
		for(Activite ac : activites) {
			System.out.println(ac.getPrix());
			
		}
		*/
		
		
		
		
		Context.getSingleton().close();

		
	}

}
