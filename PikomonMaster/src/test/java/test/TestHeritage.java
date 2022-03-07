package test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import heritageDemo.joined.DresseurJoined;
import heritageDemo.joined.InfirmiereJoined;
import heritageDemo.joined.PersonneJoined;
import heritageDemo.single.DresseurSingle;
import heritageDemo.single.InfirmiereSingle;
import heritageDemo.single.PersonneSingle;
import heritageDemo.table.DresseurTable;
import heritageDemo.table.InfirmiereTable;
import heritageDemo.table.PersonneTable;

public class TestHeritage {

	public static void main(String[] args) {
		DresseurSingle matthieu = new DresseurSingle("Matthieu", LocalDate.parse("1998-02-23"),10, null);
		matthieu.setAttributDresseur("bidon");
		InfirmiereSingle inf = new InfirmiereSingle("Joelle");
		inf.setAttributInfirmiere("ok");
		
		
		DresseurJoined matthieu2 = new DresseurJoined("Matthieu", LocalDate.parse("1998-02-23"),10, null);
		matthieu2.setAttributDresseur("bidon");
		InfirmiereJoined inf2 = new InfirmiereJoined("Joelle");
		inf2.setAttributInfirmiere("ok");
		
		
		DresseurTable matthieu3 = new DresseurTable("Matthieu", LocalDate.parse("1998-02-23"),10, null);
		matthieu3.setAttributDresseur("bidon");
		InfirmiereTable inf3 = new InfirmiereTable("Joelle");
		inf3.setAttributInfirmiere("ok");




		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("demoJPA");

		EntityManager em  = emf.createEntityManager();

		em.getTransaction().begin();
		
		em.persist(matthieu);
		em.persist(inf);
		
		em.persist(matthieu2);
		em.persist(inf2);
		
		em.persist(matthieu3);
		em.persist(inf3);
		
		em.getTransaction().commit();
		em.close();
		
		
		
		em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT p from PersonneSingle p");
		List<PersonneSingle> listSingle = q.getResultList();
		System.out.println(listSingle);
		
		q = em.createQuery("SELECT p from PersonneJoined p");
		List<PersonneJoined> listJoined = q.getResultList();
		System.out.println(listJoined);
		
		
		q = em.createQuery("SELECT p from PersonneTable p");
		List<PersonneTable> listTable = q.getResultList();
		System.out.println(listTable);
		
		em.close();
		emf.close();
	}

}
