package model;

public abstract class Animal {
	protected Integer id;
	protected String nom;

	public Animal(String nom) {
		this.nom = nom;
	}
	
	public Animal(Integer id,String nom) {
		this.nom = nom;
		this.id=id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
