package formationSpring;

import org.springframework.stereotype.Component;

@Component("manager")
public class Poste {
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
