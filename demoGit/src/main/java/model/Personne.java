package model;

public class Personne {

	private String nom;
	private String prenom;
	
	public Personne(String nom, String prenom) {
		this.prenom=prenom;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
