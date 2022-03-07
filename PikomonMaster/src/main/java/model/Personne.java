package model;

import java.time.LocalDate;

public abstract class Personne {

	protected Integer id;
	protected String nom;
	protected LocalDate naissance;
	
	
	public Personne(String nom) {
		this.nom = nom;
	}

	public Personne(String nom,LocalDate naissance) {
		this.nom = nom;
		this.naissance=naissance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	
	
	
	
}
