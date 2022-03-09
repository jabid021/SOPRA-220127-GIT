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
import dao.jdbc.DAOCompteJDBC;
import dao.jdbc.DAOReservationJDBC;
import dao.jpa.DAOAnimal;
import dao.jpa.DAOParticipant;
import dao.jpa.DAOVehicule;
import model.Compte;

public class Context {
	
//L'objet _singleton sera l'unique objet Context de l'appli et contiendra un pointeur vers tous les autres attributs	
//Obligatoire
private static Context _singleton=null;	
private EntityManagerFactory emf  = Persistence.createEntityManagerFactory("centerpark");

//Option pour notre Projet//
private Compte connected;
private IDAOCompte daoCompte = new DAOCompteJDBC();
private IDAOActivite daoActivite = new DAOActiviteJDBC();
private IDAOAnimal daoAnimal = new DAOAnimal();
private IDAOReservation daoReservation = new DAOReservationJDBC();
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
public EntityManagerFactory getEmf() {
	return emf;
}

public void setEmf(EntityManagerFactory emf) {
	this.emf = emf;
}


public void close() {
	emf.close();
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






	

}
