package test;

import dao.IDAOCompte;
import model.Compte;
import util.Context;

public class TestJPA {

	static IDAOCompte daoCompte = Context.getSingleton().getDaoCompte();
	public static void main(String[] args) {
		
	
		Compte c = Context.getSingleton().getDaoCompte().seConnecter("client@client", "client");
		System.out.println(c.getNumero());
		Context.getSingleton().close();
		
		
		
	}

}
