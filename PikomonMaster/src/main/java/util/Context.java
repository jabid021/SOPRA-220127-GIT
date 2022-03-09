package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOArene;
import dao.IDAOCentre;
import dao.IDAODresseur;
import dao.IDAOInfirmiere;
import dao.IDAOItem;
import dao.IDAOPokemon;
import dao.IDAOVille;
import dao.jpa.DAOArene;
import dao.jpa.DAOCentre;
import dao.jpa.DAODresseur;
import dao.jpa.DAOInfirmiere;
import dao.jpa.DAOItem;
import dao.jpa.DAOPokemon;
import dao.jpa.DAOVille;

public class Context {
	

private static Context _singleton=null;	
private EntityManagerFactory emf  = Persistence.createEntityManagerFactory("demoJPA");
private IDAOArene daoArene= new DAOArene();
private IDAOCentre daoCentre= new DAOCentre();
private IDAODresseur daoDresseur= new DAODresseur();
private IDAOInfirmiere daoInfirmiere= new DAOInfirmiere();
private IDAOPokemon daoPokemon= new DAOPokemon();
private IDAOVille daoVille= new DAOVille();
private IDAOItem daoItem= new DAOItem();



private Context() {}


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





public IDAOArene getDaoArene() {
	return daoArene;
}


public IDAOCentre getDaoCentre() {
	return daoCentre;
}


public IDAODresseur getDaoDresseur() {
	return daoDresseur;
}


public IDAOInfirmiere getDaoInfirmiere() {
	return daoInfirmiere;
}


public IDAOPokemon getDaoPokemon() {
	return daoPokemon;
}


public IDAOVille getDaoVille() {
	return daoVille;
}


public IDAOItem getDaoItem() {
	return daoItem;
}


public void setEmf(EntityManagerFactory emf) {
	this.emf = emf;
}


public void close() {
	emf.close();
}







	

}
