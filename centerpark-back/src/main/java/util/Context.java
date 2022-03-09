package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOActivite;
import dao.IDAOAnimal;
import dao.IDAOCompte;
import dao.IDAOParticipant;
import dao.IDAOReservation;
import dao.IDAOVehicule;
import dao.jpa.DAOActivite;
import dao.jpa.DAOAnimal;
import dao.jpa.DAOCompte;
import dao.jpa.DAOParticipant;
import dao.jpa.DAOReservation;
import dao.jpa.DAOVehicule;

public class Context {
	
private EntityManagerFactory emf  = Persistence.createEntityManagerFactory("centerpark");

private static Context _singleton=null;	

private IDAOCompte daoCompte = new DAOCompte();
private IDAOActivite daoActivite = new DAOActivite();
private IDAOAnimal daoAnimal = new DAOAnimal();
private IDAOReservation daoReservation = new DAOReservation();
private IDAOParticipant daoParticipant = new DAOParticipant();
private IDAOVehicule daoVehicule = new DAOVehicule();



//Obligatoire
private Context() {}

//Obligatoire
public static Context getSingleton() 
{
	if(_singleton==null) 
	{
		_singleton=new Context();
	}
	
	return _singleton;
}



public IDAOCompte getDaoCompte() {
	return daoCompte;
}

public void setDaoCompte(IDAOCompte daoCompte) {
	this.daoCompte = daoCompte;
}

public IDAOActivite getDaoActivite() {
	return daoActivite;
}

public void setDaoActivite(IDAOActivite daoActivite) {
	this.daoActivite = daoActivite;
}

public IDAOAnimal getDaoAnimal() {
	return daoAnimal;
}

public void setDaoAnimal(IDAOAnimal daoAnimal) {
	this.daoAnimal = daoAnimal;
}

public IDAOReservation getDaoReservation() {
	return daoReservation;
}

public void setDaoReservation(IDAOReservation daoReservation) {
	this.daoReservation = daoReservation;
}

public IDAOParticipant getDaoParticipant() {
	return daoParticipant;
}

public void setDaoParticipant(IDAOParticipant daoParticipant) {
	this.daoParticipant = daoParticipant;
}

public IDAOVehicule getDaoVehicule() {
	return daoVehicule;
}

public void setDaoVehicule(IDAOVehicule daoVehicule) {
	this.daoVehicule = daoVehicule;
}


public EntityManagerFactory getEmf() {
	return emf;
}

public void close() {emf.close();}


	

}
