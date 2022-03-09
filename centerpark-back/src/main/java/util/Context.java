package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOActivite;
import dao.IDAOAnimal;
import dao.IDAOCompte;
import dao.IDAOParticipant;
import dao.IDAOReservation;
import dao.IDAOVehicule;
import dao.jdbc.DAOActiviteJDBC;
import dao.jdbc.DAOAnimalJDBC;
import dao.jdbc.DAOCompteJDBC;
import dao.jdbc.DAOParticipantJDBC;
import dao.jdbc.DAOReservationJDBC;
import dao.jdbc.DAOVehiculeJDBC;
import dao.jpa.DAOActivite;
import model.Compte;

public class Context {
	
//L'objet _singleton sera l'unique objet Context de l'appli et contiendra un pointeur vers tous les autres attributs	
//Obligatoire
private static Context _singleton=null;	

//Option pour notre Projet//
private Compte connected;
private IDAOCompte daoCompte = new DAOCompteJDBC();
private IDAOActivite daoActivite = new DAOActivite();
private IDAOAnimal daoAnimal = new DAOAnimalJDBC();
private IDAOReservation daoReservation = new DAOReservationJDBC();
private IDAOParticipant daoParticipant = new DAOParticipantJDBC();
private IDAOVehicule daoVehicule = new DAOVehiculeJDBC();

private EntityManagerFactory emf = Persistence.createEntityManagerFactory("centerpark");


public EntityManagerFactory getEmf() {
	return emf;
}

public void setEmf(EntityManagerFactory emf) {
	this.emf = emf;
}

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


//Option pour notre Projet//
public Compte getConnected() {
	return connected;
}

public void setConnected(Compte connected) {
	this.connected = connected;
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


public void close() {
	emf.close();
	
}




	

}
