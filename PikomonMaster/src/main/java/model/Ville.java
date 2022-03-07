package model;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Obligatoire
@Entity
public class Ville {

	//Obligatoire
	@Id
	//Semi-Obligatoire (Obligatoire si on veut de l'auto increment)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	
	private transient Centre centre;
	private transient Arene arene;
	
	//Obligatoire
	public Ville() {
	}
	
	public Ville(String nom, Centre centre) {
		this.nom = nom;
		this.centre = centre;
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

	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	public Arene getArene() {
		return arene;
	}

	public void setArene(Arene arene) {
		this.arene = arene;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", centre=" + centre + "]";
	}
	
	
}
