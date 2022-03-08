package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	
	@ManyToMany
	private List<Dresseur> dresseurs;
	
	public Item() {}	
	
	public Item(String libelle) {
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Dresseur> getDresseurs() {
		return dresseurs;
	}

	public void setDresseurs(List<Dresseur> dresseurs) {
		this.dresseurs = dresseurs;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", libelle=" + libelle + "]";
	}
	
	

}
