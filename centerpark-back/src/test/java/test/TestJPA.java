package test;

import model.Animal;
import model.Sanglier;
import util.Context;

public class TestJPA {

	public static void main(String[] args) {
		
		
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
