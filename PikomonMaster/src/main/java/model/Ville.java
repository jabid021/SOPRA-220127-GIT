package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Obligatoire
@Entity
@Table(name="city") 
public class Ville {

	//Obligatoire
	@Id
	//Semi-Obligatoire (Obligatoire si on veut de l'auto increment)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_city")
	private Integer id;
	
	@Column(name="name",length = 20,nullable = false,unique = true)
	private String nom;
	
	@OneToOne
	private Centre centre;
	@OneToOne(mappedBy = "ville")
	private Arene arene;
	
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
